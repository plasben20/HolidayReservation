package org.holidayRes.reservas.ainfraestructura.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservaResponse {
    private Long Id;
    private String idVuelo;
    private String idHotel;
}
