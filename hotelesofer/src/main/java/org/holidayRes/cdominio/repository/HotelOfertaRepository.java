package org.holidayRes.cdominio.repository;

import org.holidayRes.cdominio.modelo.HotelOferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelOfertaRepository extends JpaRepository<HotelOferta, String> {

}