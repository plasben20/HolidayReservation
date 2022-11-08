package org.holidayRes.vuelos.cdominio.repository;

import org.holidayRes.vuelos.cdominio.modelo.Vuelo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

// Srping anotación
@Repository
public interface VueloRepository extends MongoRepository<Vuelo, String> {

}