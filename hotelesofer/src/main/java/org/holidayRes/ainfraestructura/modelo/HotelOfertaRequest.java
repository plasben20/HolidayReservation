package org.holidayRes.ainfraestructura.modelo;

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
