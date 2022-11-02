package org.holidayRes.hoteles.cdominio.modelo;

import lombok.*;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import javax.persistence.*;

@Document
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Hotel {
    @Id
    String id;

    @Field
    String destino;

    @Field
    Double numHabitaciones;

    @Field
    Double precioHabitacion;

    @Field
    Double precioTotal;
}
