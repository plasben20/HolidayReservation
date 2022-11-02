package org.holidayRes.reservas.ainfraestructura.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class VueloRequest {
    private String id;
    private String origen;
    private String destino;
    private Double numAsientos;
    private Double precioAsiento;
    private Double costeTotal;
}
