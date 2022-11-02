package org.holidayRes.reservas.ainfraestructura.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ReservaRequest {
    private Long Id;
    private String idVuelo;
    private String idHotel;
}
