package org.holidayRes.baplicacion.mapper;


import org.holidayRes.baplicacion.modelo.VueloOfertaModel;
import org.holidayRes.cdominio.modelo.VueloOferta;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VueloOfertaMapper {
    VueloOfertaMapper INSTANCE = Mappers.getMapper(VueloOfertaMapper.class);

    VueloOfertaModel mapToVueloOfertaModel(VueloOferta vueloOferta);
    VueloOferta mapToVueloOfertaEntity(VueloOfertaModel vueloOfertaModel);
    List<VueloOfertaModel> mapToVueloOfertaListModel(List<VueloOferta> vueloOfertaList);
}
