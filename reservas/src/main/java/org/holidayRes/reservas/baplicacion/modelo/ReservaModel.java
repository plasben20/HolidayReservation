package org.holidayRes.reservas.baplicacion.modelo;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReservaModel {
    private Long Id;
    private String idVuelo;
    private Double idHotel;
}
