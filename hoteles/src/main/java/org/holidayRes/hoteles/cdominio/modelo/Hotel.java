package org.holidayRes.hoteles.cdominio.modelo;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Hoteles")
@Getter
@Setter
public class Hotel {
    @Id
    private String id;
    @Column
    private String destino;
    @Column
    private Double numHabitaciones;
    @Column
    private Double precioHabitacion;
    @Column
    private Double precioTotal;
}