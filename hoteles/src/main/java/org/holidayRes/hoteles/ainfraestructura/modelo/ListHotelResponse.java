package org.holidayRes.hoteles.ainfraestructura.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.holidayRes.hoteles.cdominio.modelo.Hotel;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ListHotelResponse {
    List<Hotel> hotels;
}
