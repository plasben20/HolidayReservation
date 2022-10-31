package org.holidayRes.hotelesofer.cdominio.modelo;

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
public class HotelOferta {
    @Id
    String id;
    @Field
    String idHotelOferta;
    @Field
    Double numHabitaciones;
    @Field
    Double precioHabitacion;
    @Field
    Double precioTotal;
}
