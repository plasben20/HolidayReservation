package org.holidayRes.hotelesofer.ainfraestructura.modelo;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelOfertaResponse {
    private String id;
    private String idHotelOferta;
    private Double numHabitaciones;
    private Double precioHabitacion;
    private Double precioTotal;
}
