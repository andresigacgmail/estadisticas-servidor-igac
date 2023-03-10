package com.igac.estadisticasservidorigac.controllers;

import com.igac.estadisticasservidorigac.entities.Servidor;
import com.igac.estadisticasservidorigac.services.ServidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servidor")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ServidorController {

    @Autowired private ServidorService servidorService;


    @GetMapping
    public ResponseEntity<List<Servidor>> getAll(){
        return ResponseEntity.ok(servidorService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Servidor> getServer(@PathVariable("id") long id){
        return ResponseEntity.ok(servidorService.getServer(id).get());
    }

    @PostMapping
    public ResponseEntity<Servidor> saveServer(@RequestBody Servidor servidor){
        return new ResponseEntity<>(servidorService.saveServer(servidor), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Servidor> updateServer(@RequestBody Servidor servidor, @PathVariable("id") long id){
        return new ResponseEntity<>(servidorService.updateServer(servidor, id), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteServer(@PathVariable("id") long id){
        servidorService.deleteServer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }







}
