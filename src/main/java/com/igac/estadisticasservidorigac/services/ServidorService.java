package com.igac.estadisticasservidorigac.services;

import com.igac.estadisticasservidorigac.entities.Servidor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ServidorService {

    List<Servidor> getAll();

    Optional<Servidor> getServer(long id);
    Servidor saveServer(Servidor servidor);

    Servidor updateServer(Servidor servidor, long id);

    void deleteServer(long id);


}
