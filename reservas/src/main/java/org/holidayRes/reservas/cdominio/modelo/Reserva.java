package org.holidayRes.reservas.cdominio.modelo;

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
public class Reserva {
    @Id
    Long Id;

    @Field
    String idVuelo;

    @Field
    Double idHotel;
}
