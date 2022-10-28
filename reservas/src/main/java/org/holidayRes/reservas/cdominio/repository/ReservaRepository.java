package org.holidayRes.reservas.cdominio.repository;

import org.holidayRes.reservas.cdominio.modelo.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, String> {

}