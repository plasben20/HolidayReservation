package org.holidayRes.vuelos.cdominio.modelo;

import lombok.*;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import javax.persistence.Entity;
import javax.persistence.Id;

@Document
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Vuelo {
    @Id
    String id;

    @Field
    String origen;

    @Field
    String destino;

    @Field
    Double numAsientos;

    @Field
    Double precioAsiento;

    @Field
    Double costeTotal;
}
