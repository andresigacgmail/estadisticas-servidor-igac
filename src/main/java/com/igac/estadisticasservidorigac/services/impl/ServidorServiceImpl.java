package com.igac.estadisticasservidorigac.services.impl;


import com.igac.estadisticasservidorigac.entities.Servidor;
import com.igac.estadisticasservidorigac.repositories.ServidorRepository;
import com.igac.estadisticasservidorigac.services.ServidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServidorServiceImpl implements ServidorService {

    @Autowired private ServidorRepository servidorRepository;

    @Override
    public List<Servidor> getAll() {
        return servidorRepository.findAll();
    }

    @Override
    public Optional<Servidor> getServer(long id) {
        return getAndValidateServer(id);
    }

    @Override
    public Servidor saveServer(Servidor servidor) {
        return servidorRepository.save(servidor);
    }

    @Override
    public Servidor updateServer(Servidor servidor, long id) {
        Optional<Servidor> servidorOptional = getAndValidateServer(id);
        if(servidorOptional.isEmpty()){
            return null;
        }

        servidorOptional.get().setIp_publica(servidor.getIp_publica());
        servidorOptional.get().setIp_local(servidor.getIp_local());

        return servidorRepository.save(servidorOptional.get());
    }

    @Override
    public void deleteServer(long id) {
        Optional<Servidor> servidor = getAndValidateServer(id);
        servidorRepository.delete(servidor.get());
        //return servidor.isEmpty() ? false : true;
    }


    private Optional<Servidor> getAndValidateServer(long id){
        Optional<Servidor> servidor = servidorRepository.findById(id);
        return servidor;
    }

}
