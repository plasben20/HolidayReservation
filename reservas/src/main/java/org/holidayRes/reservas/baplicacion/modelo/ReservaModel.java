package org.holidayRes.reservas.baplicacion.modelo;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReservaModel {
    private String id;
    private String idVuelo;
    private String idHotel;
}
