package org.holidayRes.reservas.ainfraestructura.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VueloResponse {
    private String id;
    private String origen;
    private String destino;
    private Double numAsientos;
    private Double precioAsiento;
    private Double costeTotal;
}
