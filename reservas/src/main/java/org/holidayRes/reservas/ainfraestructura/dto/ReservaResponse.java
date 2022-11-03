package org.holidayRes.reservas.ainfraestructura.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservaResponse {
    private String id;
    private String idVuelo;
    private String idHotel;
}
