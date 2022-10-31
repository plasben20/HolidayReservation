package org.holidayRes.vuelosofer.cdominio.modelo;

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
public class VueloOferta {
    @Id
    String id;
    @Field
    String idVuelo;
    @Field
    Double numAsientos;
    @Field
    Double precioAsiento;
    @Field
    Double costeTotal;
}
