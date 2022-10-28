package org.holidayRes.hoteles.baplicacion.mapper;

import org.holidayRes.hoteles.baplicacion.modelo.HotelModel;
import org.holidayRes.hoteles.cdominio.modelo.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HotelMapper {
    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

    HotelModel mapToHotelModel(Hotel hotel);
    Hotel mapToHotelEntity(HotelModel hotelModel);
    List<HotelModel> mapToHotelListModel(List<Hotel> hotelList);
}
