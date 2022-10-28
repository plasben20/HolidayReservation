package org.holidayRes.reservas.baplicacion.service;

import org.holidayRes.reservas.baplicacion.mapper.ReservaMapper;
import org.holidayRes.reservas.baplicacion.modelo.ReservaModel;
import org.holidayRes.reservas.cdominio.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {
    @Autowired
    ReservaRepository reservaRepository;

    public void upsertReserva(ReservaModel reserva) {
        reservaRepository.save(ReservaMapper.INSTANCE.mapToReservaEntity(reserva));
    }

    public ReservaModel findReservaById(String referencia){
        return ReservaMapper.INSTANCE.mapToReservaModel(reservaRepository.findById(referencia).orElse(null));
    }

    public boolean enTabla(String referencia){ return (findReservaById(referencia)!=null); }

    public void deleteByReferencia(String referencia) {
        if (findReservaById(referencia)!=null)
            reservaRepository.deleteById(referencia);
    }

    public List<ReservaModel> findAllReservas() {
        return ReservaMapper.INSTANCE.mapToReservaListModel(reservaRepository.findAll());
    }
}