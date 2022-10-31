package org.holidayRes.hotelesofer.ainfraestructura.mapper;

import org.holidayRes.hotelesofer.ainfraestructura.modelo.HotelOfertaRequest;
import org.holidayRes.hotelesofer.ainfraestructura.modelo.HotelOfertaResponse;
import org.holidayRes.hotelesofer.baplicacion.modelo.HotelOfertaModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HotelOfertaRestMapper {

    HotelOfertaRestMapper INSTANCE = Mappers.getMapper(HotelOfertaRestMapper.class);

    HotelOfertaModel mapToHotelOfertaModel(HotelOfertaRequest Request);

    HotelOfertaResponse mapToHotelOfertaResponse(HotelOfertaModel hotelOfertaModel);

    List<HotelOfertaResponse> mapToHotelOfertaListResponse(List<HotelOfertaModel> hotelOfertaModelList);

}
