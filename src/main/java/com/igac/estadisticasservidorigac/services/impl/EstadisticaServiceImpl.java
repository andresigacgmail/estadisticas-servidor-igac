package com.igac.estadisticasservidorigac.services.impl;

import com.igac.estadisticasservidorigac.dtos.EstadisticaDto;
import com.igac.estadisticasservidorigac.entities.Estadistica;
import com.igac.estadisticasservidorigac.entities.Servidor;
import com.igac.estadisticasservidorigac.excepciones.ResourceNotFoundException;
import com.igac.estadisticasservidorigac.repositories.EstadisticaRepository;
import com.igac.estadisticasservidorigac.repositories.ServidorRepository;
import com.igac.estadisticasservidorigac.services.EstadisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class EstadisticaServiceImpl implements EstadisticaService {


    private final String HTTP = "http://";
    private final String PUERTO_ENDPOINT = ":8080/stat";
    @Autowired private RestTemplate restTemplate;

    @Autowired private ServidorRepository servidorRepository;

    @Autowired private EstadisticaRepository estadisticaRepository;

    @Override
    public Map<String, Object> estadisticaServerIndividual(long id) {
        Map<String, Object> map = new HashMap<>();

        Servidor servidor = servidorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Servidor","id",String.valueOf(id)));

        EstadisticaDto estadisticaDto = restTemplate.getForObject("http://"+servidor.getIp_publica()+":8080/stat", EstadisticaDto.class);
        map.put("Servidor", servidor);
        map.put("Estadistica", estadisticaDto);

        return map;
    }

    @Override
    public void guardarEstadosAutomatico() {
        List<Servidor> servidores = servidorRepository.findAll();
        List<Estadistica> estadisticas = new ArrayList<>();
        for(Servidor servidor : servidores){
            EstadisticaDto estadisticaDto = restTemplate.getForObject("http://"+servidor.getIp_publica()+":8080/stat", EstadisticaDto.class);
            estadisticas.add(dtoToEntity(estadisticaDto, servidor.getId()));
        }
        estadisticaRepository.saveAll(estadisticas);
    }

    public Map<String, Object> grupoEstadisticas(long id){
        Map<String, Object> map = new HashMap<>();
        List<Estadistica> estadisticas = estadisticaRepository.findEstadisticasById_servidor(id);
        Optional<Servidor> servidor = servidorRepository.findById(id);
            servidor.orElseThrow(() -> new ResourceNotFoundException("Servidor","id",String.valueOf(id)));
        List<String> anos = estadisticaRepository.listaDeAnos(id);

        map.put("servidor", servidor);
        map.put("estadisticas", estadisticas);
        map.put("anos", anos);
        return map;
    }

    public List<String> listaDeAnos(long id_servidor){
        return estadisticaRepository.listaDeAnos(id_servidor);
    }

    public Map<String, Object> consultarPorFechas(long id, String ano, String mes, String dia){
        return consultaMesesPorAno(id, ano, mes);
    }

    private Map<String, Object> consultaMesesPorAno(long id, String ano, String mes){

        servidorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Servidor","id",String.valueOf(id)));
        String tamanoTotal = "0";

        List<String> datos = new ArrayList<>();


        Map<String, Object> tamano = new HashMap<>();


        for (int i = 1; i<=12 ; i++){
            Optional<Estadistica> estadistica1 = estadisticaRepository.tamanoTotalDiscoPorMes(id, ano, String.valueOf(i));
            if(estadistica1.isEmpty()){
                datos.add(String.valueOf( "0" ));
            }
            else {
                datos.add(String.valueOf( estadistica1.get().getDisco_uso()));
                tamanoTotal = String.valueOf( estadistica1.get().getDisco_total() );
            }
        }

        tamano.put("tamanoTotal", tamanoTotal);
        tamano.put("meses", datos);



        return tamano;
    }




    private Estadistica dtoToEntity(EstadisticaDto estadisticaDto, long id){

        return new Estadistica(
                estadisticaDto.getDiscos().get(0).getDisco_total(),
                estadisticaDto.getDiscos().get(0).getDisco_disponible(),
                estadisticaDto.getDiscos().get(0).getDisco_uso(),
                estadisticaDto.getMemoria_total(),
                estadisticaDto.getMemoria_disponible(),
                estadisticaDto.getMemoria_uso(),
                id
        );
    }
}
