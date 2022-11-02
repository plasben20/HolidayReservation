package org.holidayRes.ainfraestructura.modelo;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelOfertaResponse {
    private String id;
    private String idHotel;
    private Double numHabitaciones;
    private Double precioHabitacion;
    private Double precioTotal;
}
