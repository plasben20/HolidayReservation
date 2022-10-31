package org.holidayRes.hotelesofer.baplicacion.mapper;

import org.holidayRes.hotelesofer.baplicacion.modelo.HotelOfertaModel;
import org.holidayRes.hotelesofer.cdominio.modelo.HotelOferta;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HotelOfertaMapper {
    HotelOfertaMapper INSTANCE = Mappers.getMapper(HotelOfertaMapper.class);

    HotelOfertaModel mapToHotelOfertaModel(HotelOferta hotelOferta);
    HotelOferta mapToHotelOfertaEntity(HotelOfertaModel hotelOfertaModel);
    List<HotelOfertaModel> mapToHotelOfertaListModel(List<HotelOferta> hotelOfertaList);
}
