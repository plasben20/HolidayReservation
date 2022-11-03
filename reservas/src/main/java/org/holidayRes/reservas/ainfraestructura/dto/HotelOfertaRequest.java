package org.holidayRes.reservas.ainfraestructura.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class HotelOfertaRequest {
    private String id;
    private String idHotel;
    private Double numHabitaciones;
    private Double precioHabitacion;
    private Double precioTotal;
}
