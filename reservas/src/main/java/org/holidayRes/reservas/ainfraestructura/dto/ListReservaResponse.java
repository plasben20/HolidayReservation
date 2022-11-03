package org.holidayRes.reservas.ainfraestructura.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.holidayRes.reservas.cdominio.modelo.Reserva;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ListReservaResponse {
    List<Reserva> reservas;
}
