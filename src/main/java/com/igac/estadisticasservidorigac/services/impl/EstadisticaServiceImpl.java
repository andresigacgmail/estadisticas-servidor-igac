package com.igac.estadisticasservidorigac.services.impl;

import com.igac.estadisticasservidorigac.dtos.EstadisticaDto;
import com.igac.estadisticasservidorigac.entities.Estadistica;
import com.igac.estadisticasservidorigac.entities.Servidor;
import com.igac.estadisticasservidorigac.repositories.EstadisticaRepository;
import com.igac.estadisticasservidorigac.repositories.ServidorRepository;
import com.igac.estadisticasservidorigac.services.EstadisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class EstadisticaServiceImpl implements EstadisticaService {


    @Autowired private RestTemplate restTemplate;

    @Autowired private ServidorRepository servidorRepository;

    @Autowired private EstadisticaRepository estadisticaRepository;

    @Override
    public Map<String, Object> estadisticaServerIndividual(long id) {
        Map<String, Object> map = new HashMap<>();
        Servidor servidor = servidorRepository.findById(id).get();
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

        map.put("Servidor", servidor);
        map.put("Estadisticas", estadisticas);
        return map;
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
