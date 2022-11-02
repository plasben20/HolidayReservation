package org.holidayRes.vuelos.cdominio.repository;

import org.holidayRes.vuelos.cdominio.modelo.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, String> {

}