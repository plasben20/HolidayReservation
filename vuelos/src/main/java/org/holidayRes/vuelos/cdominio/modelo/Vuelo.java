package org.holidayRes.vuelos.cdominio.modelo;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "Vuelo")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Vuelo {
    @Id
    private String id;
    private String origen;
    private String destino;
    private Double numAsientos;
    private Double precioAsiento;
    private Double costeTotal;
}
