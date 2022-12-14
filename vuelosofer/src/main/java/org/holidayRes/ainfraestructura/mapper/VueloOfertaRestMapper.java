package org.holidayRes.ainfraestructura.mapper;

import org.holidayRes.ainfraestructura.modelo.VueloOfertaRequest;
import org.holidayRes.ainfraestructura.modelo.VueloOfertaResponse;
import org.holidayRes.baplicacion.modelo.VueloOfertaModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VueloOfertaRestMapper {

    VueloOfertaRestMapper INSTANCE = Mappers.getMapper(VueloOfertaRestMapper.class);

    VueloOfertaModel mapToVueloOfertaModel(VueloOfertaRequest Request);

    VueloOfertaResponse mapToVueloOfertaResponse(VueloOfertaModel vueloOfertaModel);

    List<VueloOfertaResponse> mapToVueloOfertaListResponse(List<VueloOfertaModel> vueloOfertaModelList);

}
