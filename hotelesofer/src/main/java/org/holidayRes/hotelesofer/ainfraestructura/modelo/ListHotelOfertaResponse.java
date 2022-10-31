package org.holidayRes.hotelesofer.ainfraestructura.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.holidayRes.hotelesofer.cdominio.modelo.HotelOferta;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ListHotelOfertaResponse {
    List<HotelOferta> hotelOfertas;
}
