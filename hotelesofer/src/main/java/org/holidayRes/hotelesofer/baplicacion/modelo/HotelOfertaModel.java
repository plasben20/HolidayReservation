package org.holidayRes.hotelesofer.baplicacion.modelo;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HotelOfertaModel {
    private String id;
    String idHotelOferta;
    Double numHabitaciones;
    Double precioHabitacion;
    Double precioTotal;
}
