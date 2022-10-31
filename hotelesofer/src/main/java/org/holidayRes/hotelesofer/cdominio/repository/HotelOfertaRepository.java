package org.holidayRes.hotelesofer.cdominio.repository;

import org.holidayRes.hotelesofer.cdominio.modelo.HotelOferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelOfertaRepository extends JpaRepository<HotelOferta, String> {

}