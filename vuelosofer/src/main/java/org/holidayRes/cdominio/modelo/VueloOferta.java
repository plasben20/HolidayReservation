package org.holidayRes.cdominio.modelo;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "VueloOferta")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VueloOferta {
    @Id
    private String id;
    private String idVuelo;
    private Double numAsientos;
    private Double precioAsiento;
    private Double costeTotal;
}
