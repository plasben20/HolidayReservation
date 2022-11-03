package org.holidayRes.hoteles.ainfraestructura.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class HotelRequest {
    private String id;
    private String destino;
    private Double numHabitaciones;
    private Double precioHabitacion;
    private Double precioTotal;
}
