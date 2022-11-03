package org.holidayRes.vuelos.ainfraestructura.mapper;

import org.holidayRes.vuelos.ainfraestructura.modelo.VueloRequest;
import org.holidayRes.vuelos.ainfraestructura.modelo.VueloResponse;
import org.holidayRes.vuelos.baplicacion.modelo.VueloModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VueloRestMapper {

    VueloRestMapper INSTANCE = Mappers.getMapper(VueloRestMapper.class);

    VueloModel mapToVueloModel(VueloRequest Request);

    VueloResponse mapToVueloResponse(VueloModel vueloModel);

    List<VueloResponse> mapToVueloListResponse(List<VueloModel> vueloModelList);

}
