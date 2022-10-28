package org.holidayRes.reservas.ainfraestructura.modelo;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservaResponse {
    private Long Id;
    private String idVuelo;
    private Double idHotel;
}
