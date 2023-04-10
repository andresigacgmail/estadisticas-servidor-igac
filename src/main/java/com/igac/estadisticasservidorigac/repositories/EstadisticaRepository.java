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


    @Query(value = "select distinct( cast ( extract(year from creado) as int) ) as year from estadisticas e WHERE e.id_servidor = ?1", nativeQuery = true)
    List<String> listaDeAnos(long id_servidor);


    @Query(value = "SELECT * FROM estadisticas WHERE id_servidor = ?1 and extract(year from creado) = ?2", nativeQuery = true)
    List<Estadistica> consultarPorAnos(long id, String ano);


    @Query(value = "SELECT * FROM estadisticas WHERE id_servidor = ?1 and cast( cast( extract( year from creado) as int ) as text) = ?2 and cast( cast( extract(month from creado) as int ) as text) = ?3 ORDER by creado desc LIMIT 1", nativeQuery = true)
    Optional<Estadistica> tamanoTotalDiscoPorMes(long id, String ano, String mes);

    @Query(value = "SELECT * FROM estadisticas WHERE id_servidor = ?1 and cast( cast( extract(year from creado) as int ) as text) = ?2 and cast( cast( extract(month from creado) as int ) as text) = ?3 ", nativeQuery = true)
    List<Estadistica> tamanoTotalDiscoPorSemana(long id, String ano, String mes);

    @Query(value = "SELECT * FROM estadisticas WHERE id_servidor = ?1 and cast( cast(  extract(year from creado) as int ) as text) = ?2 and cast( cast(  extract(month from creado) as int ) as text) = ?3 and cast( cast(  extract(day from creado) as int ) as text) = ?4", nativeQuery = true)
    Optional<Estadistica> estadisticaPorDia(long id, String ano, String mes, String dia);









}
