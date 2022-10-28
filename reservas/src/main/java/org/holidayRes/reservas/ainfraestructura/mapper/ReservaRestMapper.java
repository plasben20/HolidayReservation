package org.holidayRes.reservas.ainfraestructura.mapper;

import org.holidayRes.reservas.ainfraestructura.modelo.ReservaRequest;
import org.holidayRes.reservas.ainfraestructura.modelo.ReservaResponse;
import org.holidayRes.reservas.baplicacion.modelo.ReservaModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReservaRestMapper {

    ReservaRestMapper INSTANCE = Mappers.getMapper(ReservaRestMapper.class);

    ReservaModel mapToReservaModel(ReservaRequest Request);

    ReservaResponse mapToReservaResponse(ReservaModel reservaModel);

    List<ReservaResponse> mapToReservaListResponse(List<ReservaModel> reservaModelList);

}
