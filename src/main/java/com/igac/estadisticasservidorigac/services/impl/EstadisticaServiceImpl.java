package com.igac.estadisticasservidorigac.services.impl;

import com.igac.estadisticasservidorigac.dtos.EstadisticaDto;
import com.igac.estadisticasservidorigac.dtos.MesDto;
import com.igac.estadisticasservidorigac.dtos.SemanaDto;
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


    private final String arrayMeses [] = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
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
        Optional<Servidor> servidor = servidorRepository.findById(id);
            servidor.orElseThrow(() -> new ResourceNotFoundException("Servidor","id",String.valueOf(id)));
        List<Estadistica> estadisticas = estadisticaRepository.findEstadisticasById_servidor(id);
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

        if(!ano.equals("0") && !mes.equals("0") && !dia.equals("0")){
            return consultaPorDia(id, ano, mes, dia);
        }else if(!ano.equals("0") && !mes.equals("0") && dia.equals("0")){
            return consultaSemanasPorMes(id, ano, mes);
        }else if(!ano.equals("0") && mes.equals("0") && dia.equals("0")){
            return consultaMesesPorAno(id, ano);
        }
        return null;
    }

    private Map<String, Object> consultaMesesPorAno(long id, String ano){

        servidorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Servidor","id",String.valueOf(id)));
        String tamanoTotal = "0";

        List<MesDto> meses = new ArrayList<>();
        Map<String, Object> tamano = new HashMap<>();


        for (int i = 1; i<=12 ; i++){
            Optional<Estadistica> estadistica = estadisticaRepository.tamanoTotalDiscoPorMes(id, ano, String.valueOf(i));
            if(estadistica.isEmpty()){
                meses.add(new MesDto(arrayMeses[i-1], "0"));            }
            else {
                tamanoTotal = String.valueOf( estadistica.get().getDisco_total() );
                meses.add(new MesDto(arrayMeses[i-1], String.valueOf( estadistica.get().getDisco_uso())));
            }
        }

        tamano.put("tamanoTotal", tamanoTotal);
        tamano.put("meses", meses);
        return tamano;
    }


    private Map<String, Object> consultaSemanasPorMes(long id, String ano, String mes){

        servidorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Servidor","id",String.valueOf(id)));
        String tamanoTotal = "0";

        List<SemanaDto> semanas = new ArrayList<>();
        Map<String, Object> tamano = new HashMap<>();

        List<Estadistica> estadisticas = estadisticaRepository.tamanoTotalDiscoPorSemana(id, ano, mes);
        int mesLength = estadisticas.size();
        int semanaLength = mesLength / 4;


        for (int i=0; i<4;i++){
            Optional<Estadistica> estadistica = estadisticaRepository.estadisticaPorDia(id, ano, mes, String.valueOf(semanaLength));
            if(estadistica.isPresent()){
                semanas.add(new SemanaDto("Semana "+String.valueOf(i+1), String.valueOf( estadistica.get().getDisco_uso() )));
            }else {
                semanas.add(new SemanaDto("Semana "+String.valueOf(i+1), "0"));
            }
            semanaLength = semanaLength +semanaLength;
        }



        tamano.put("tamanoTotal", tamanoTotal);
        tamano.put("meses", semanas);
        return tamano;
    }

    private Map<String, Object> consultaPorDia(long id, String ano, String mes, String dia){

        servidorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Servidor","id",String.valueOf(id)));
        List<Estadistica> estadisticas = new ArrayList<>();

        Optional<Estadistica> estadistica = estadisticaRepository.estadisticaPorDia(id, ano, mes , dia);
            estadistica.orElseThrow(() -> new ResourceNotFoundException("Estadistica","id", String.valueOf(id)));

        estadisticas.add(estadistica.get());

        Map<String, Object> tamano = new HashMap<>();
        tamano.put("estadisticas", estadisticas);
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
