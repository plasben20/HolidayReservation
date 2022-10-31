package org.holidayRes.reservas.ainfraestructura.modelo;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelResponse {
    private String id;
    private String destino;
    private Double numHabitaciones;
    private Double precioHabitacion;
    private Double precioTotal;
}
