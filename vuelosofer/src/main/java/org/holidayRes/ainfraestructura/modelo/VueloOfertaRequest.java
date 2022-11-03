package org.holidayRes.ainfraestructura.modelo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VueloOfertaRequest {
    private String id;
    private String idVuelo;
    private Double numAsientos;
    private Double precioAsiento;
    private Double costeTotal;
}
