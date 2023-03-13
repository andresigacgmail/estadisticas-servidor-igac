package com.igac.estadisticasservidorigac.controllers;

import com.igac.estadisticasservidorigac.dtos.EstadisticaDto;
import com.igac.estadisticasservidorigac.services.EstadisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("estadistica")
public class EstadisticaController {

    @Autowired private EstadisticaService estadisticaService;

    @GetMapping("{id}")
    public ResponseEntity<Map<String, Object>> getStat(@PathVariable("id") long id){
        return new ResponseEntity<>(estadisticaService.estadisticaServerIndividual(id), HttpStatus.OK);
    }

    @GetMapping
    public void guardarStats(){
        estadisticaService.guardarEstadosAutomatico();
    }

    @GetMapping("/grupo/{id}")
    public ResponseEntity<Map<String, Object>> grupoEstadisticas(@PathVariable("id") long id){
        return ResponseEntity.ok(estadisticaService.grupoEstadisticas(id));
    }
}
