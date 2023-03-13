package com.igac.estadisticasservidorigac.repositories;

import com.igac.estadisticasservidorigac.entities.Servidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServidorRepository extends JpaRepository<Servidor, Long> {


}
