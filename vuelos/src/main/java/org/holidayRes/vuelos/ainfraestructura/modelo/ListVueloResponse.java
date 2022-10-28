package org.holidayRes.vuelos.ainfraestructura.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.holidayRes.vuelos.cdominio.modelo.Vuelo;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ListVueloResponse {
    List<Vuelo> vuelos;
}
