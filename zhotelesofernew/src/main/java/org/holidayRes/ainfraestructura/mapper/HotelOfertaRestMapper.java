package org.holidayRes.ainfraestructura.mapper;

import org.holidayRes.ainfraestructura.modelo.HotelOfertaRequest;
import org.holidayRes.ainfraestructura.modelo.HotelOfertaResponse;
import org.holidayRes.baplicacion.modelo.HotelOfertaModel;
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
