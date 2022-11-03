package org.holidayRes.vuelos.baplicacion.mapper;

import org.holidayRes.vuelos.baplicacion.modelo.VueloModel;
import org.holidayRes.vuelos.cdominio.modelo.Vuelo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VueloMapper {
    VueloMapper INSTANCE = Mappers.getMapper(VueloMapper.class);

    VueloModel mapToVueloModel(Vuelo vuelo);
    Vuelo mapToVueloEntity(VueloModel vueloModel);
    List<VueloModel> mapToVueloListModel(List<Vuelo> vueloList);
}
