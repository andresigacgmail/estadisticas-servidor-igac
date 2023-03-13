package com.igac.estadisticasservidorigac.services;

import com.igac.estadisticasservidorigac.dtos.EstadisticaDto;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface EstadisticaService {


    Map<String, Object> estadisticaServerIndividual(long id);

    void guardarEstadosAutomatico();

    Map<String, Object> grupoEstadisticas(long id);

}
