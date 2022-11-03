package org.holidayRes.ainfraestructura.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.holidayRes.cdominio.modelo.HotelOferta;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ListHotelOfertaResponse {
    List<HotelOferta> hotelOfertas;
}
