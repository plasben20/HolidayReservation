package org.holidayRes.vuelosofer.cdominio.repository;

import org.holidayRes.vuelosofer.cdominio.modelo.VueloOferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloOfertaRepository extends JpaRepository<VueloOferta, String> {

}