package org.holidayRes.reservas.baplicacion.mapper;

import org.holidayRes.reservas.baplicacion.modelo.ReservaModel;
import org.holidayRes.reservas.cdominio.modelo.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReservaMapper {
    ReservaMapper INSTANCE = Mappers.getMapper(ReservaMapper.class);

    ReservaModel mapToReservaModel(Reserva reserva);
    Reserva mapToReservaEntity(ReservaModel reservaModel);
    List<ReservaModel> mapToReservaListModel(List<Reserva> reservaList);
}
