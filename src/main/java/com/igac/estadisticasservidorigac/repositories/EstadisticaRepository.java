package com.igac.estadisticasservidorigac.repositories;

import com.igac.estadisticasservidorigac.entities.Estadistica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstadisticaRepository extends JpaRepository<Estadistica, Long> {

    @Query(value = "SELECT * FROM estadisticas e WHERE e.id_servidor = ?1 order by e.creado desc limit 5", nativeQuery = true)
    List<Estadistica> findEstadisticasById_servidor(long id);


    @Query(value = "select distinct( SUBSTRING(creado, 1, 4) ) as year from estadisticas e WHERE e.id_servidor = ?1", nativeQuery = true)
    List<String> listaDeAnos(long id_servidor);


    @Query(value = "SELECT * FROM estadisticas WHERE id_servidor = ?1 and YEAR(creado) = ?2", nativeQuery = true)
    List<Estadistica> consultarPorAnos(long id, String ano);


    @Query(value = "SELECT * FROM estadisticas WHERE id_servidor = ?1 and YEAR(creado) = ?2 and month(creado) = ?3 ORDER by creado desc LIMIT 1", nativeQuery = true)
    Optional<Estadistica> tamanoTotalDiscoPorMes(long id, String ano, String mes);

    @Query(value = "SELECT * FROM estadisticas WHERE id_servidor = ?1 and YEAR(creado) = ?2 and month(creado) = ?3 ", nativeQuery = true)
    List<Estadistica> tamanoTotalDiscoPorSemana(long id, String ano, String mes);

    @Query(value = "SELECT * FROM estadisticas WHERE id_servidor = ?1 and YEAR(creado) = ?2 and month(creado) = ?3 and day(creado) = ?4", nativeQuery = true)
    Optional<Estadistica> estadisticaPorDia(long id, String ano, String mes, String dia);









}
