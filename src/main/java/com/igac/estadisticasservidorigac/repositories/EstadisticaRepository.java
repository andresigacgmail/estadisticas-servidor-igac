package com.igac.estadisticasservidorigac.repositories;

import com.igac.estadisticasservidorigac.entities.Estadistica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadisticaRepository extends JpaRepository<Estadistica, Long> {

    @Query(value = "SELECT * FROM estadisticas u WHERE u.id_servidor = ?1", nativeQuery = true)
    List<Estadistica> findEstadisticasById_servidor(long id);

}
