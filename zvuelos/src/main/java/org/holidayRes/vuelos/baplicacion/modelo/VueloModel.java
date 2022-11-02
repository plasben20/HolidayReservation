package org.holidayRes.vuelos.baplicacion.modelo;

import lombok.*;
import org.springframework.data.couchbase.core.mapping.Field;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class VueloModel {
    private String id;
    private String origen;
    private String destino;
    private Double numAsientos;
    private Double precioAsiento;
    private Double costeTotal;
}
