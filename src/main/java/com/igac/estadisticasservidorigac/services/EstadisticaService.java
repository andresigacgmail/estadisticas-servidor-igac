package com.igac.estadisticasservidorigac.services;

import com.igac.estadisticasservidorigac.dtos.EstadisticaDto;
import com.igac.estadisticasservidorigac.entities.Estadistica;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public interface EstadisticaService {


    Map<String, Object> estadisticaServerIndividual(long id);

    void guardarEstadosAutomatico();

    Map<String, Object> grupoEstadisticas(long id);

    List<Estadistica> consultarPorFechas(long id, String ano, String mes, String dia);

    List<String> listaDeAnos(long idServidor);
}
