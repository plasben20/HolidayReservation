package org.holidayRes.cdominio.repository;

import org.holidayRes.cdominio.modelo.VueloOferta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloOfertaRepository extends MongoRepository<VueloOferta, String> {

}