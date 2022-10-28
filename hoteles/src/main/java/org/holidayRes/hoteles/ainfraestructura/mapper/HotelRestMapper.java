package org.holidayRes.hoteles.ainfraestructura.mapper;

import org.holidayRes.hoteles.ainfraestructura.modelo.HotelRequest;
import org.holidayRes.hoteles.ainfraestructura.modelo.HotelResponse;
import org.holidayRes.hoteles.baplicacion.modelo.HotelModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HotelRestMapper {

    HotelRestMapper INSTANCE = Mappers.getMapper(HotelRestMapper.class);

    HotelModel mapToHotelModel(HotelRequest Request);

    HotelResponse mapToHotelResponse(HotelModel hotelModel);

    List<HotelResponse> mapToHotelListResponse(List<HotelModel> hotelModelList);

}
