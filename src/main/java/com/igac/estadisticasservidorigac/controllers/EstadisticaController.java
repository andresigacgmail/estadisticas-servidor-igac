package com.igac.estadisticasservidorigac.controllers;

import com.igac.estadisticasservidorigac.entities.Estadistica;
import com.igac.estadisticasservidorigac.services.EstadisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("estadistica")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
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

    @GetMapping("/ano/{id_servidor}")
    public ResponseEntity<List<String>> listaDeAnosPorServidor(@PathVariable("id_servidor") long id_servidor){
        return new ResponseEntity<>(estadisticaService.listaDeAnos(id_servidor), HttpStatus.OK);
    }

    @GetMapping("/ano")
    public ResponseEntity<List<Estadistica>> listaDeAnosPorServidor(
            @RequestParam("id_servidor") long id_servidor,
            @RequestParam("ano") String ano,
            @RequestParam("mes") String mes,
            @RequestParam("dia") String dia
    ){
        return new ResponseEntity<>(estadisticaService.consultarPorFechas(id_servidor, ano, mes, dia), HttpStatus.OK);
    }
}
