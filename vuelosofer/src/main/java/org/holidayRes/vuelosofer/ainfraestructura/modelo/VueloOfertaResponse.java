package org.holidayRes.vuelosofer.ainfraestructura.modelo;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VueloOfertaResponse {
    private String id;
    private String idVuelo;
    private Double numAsientos;
    private Double precioAsiento;
    private Double costeTotal;
}
