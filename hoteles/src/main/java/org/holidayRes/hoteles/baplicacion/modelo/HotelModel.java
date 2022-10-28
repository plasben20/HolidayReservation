package org.holidayRes.hoteles.baplicacion.modelo;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HotelModel {
    private String id;
    private String destino;
    private Double numHabitaciones;
    private Double precioHabitacion;
    private Double precioTotal;
}
