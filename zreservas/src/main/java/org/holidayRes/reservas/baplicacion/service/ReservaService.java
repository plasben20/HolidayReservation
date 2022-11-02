package org.holidayRes.reservas.baplicacion.service;

import org.holidayRes.reservas.baplicacion.modelo.ReservaModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservaService {

    public void upsertReserva(ReservaModel reserva);
    public ReservaModel findReservaById(String referencia);
    public boolean enTabla(String referencia);
    public void deleteByReferencia(String referencia);
    public List<ReservaModel> findAllReservas();

    boolean hayOfertaVuelo(String idVuelo);

    boolean hayOfertaHotel(String idHotel);
}