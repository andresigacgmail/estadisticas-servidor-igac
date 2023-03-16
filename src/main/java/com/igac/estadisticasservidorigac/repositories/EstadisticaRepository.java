package com.igac.estadisticasservidorigac.repositories;

import com.igac.estadisticasservidorigac.entities.Estadistica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadisticaRepository extends JpaRepository<Estadistica, Long> {

    @Query(value = "SELECT * FROM estadisticas e WHERE e.id_servidor = ?1 order by e.creado desc limit 5", nativeQuery = true)
    List<Estadistica> findEstadisticasById_servidor(long id);


    @Query(value = "select distinct( SUBSTRING(creado, 1, 4) ) as year from estadisticas e WHERE e.id_servidor = ?1", nativeQuery = true)
    List<String> listaDeAnos(long id_servidor);


    @Query(value = "select * from estadisticas e WHERE e.id_servidor = ?1 ", nativeQuery = true)
    List<Estadistica> consultarPorAnos(long id);
//    List<String> meses(long id, String ano);
//    List<String> dias(long id, String mes);

    //List<Estadistica> findEstadisticasById_servidor();






}
