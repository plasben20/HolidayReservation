package org.holidayRes.hotelesofer.baplicacion.service;

import org.holidayRes.hotelesofer.baplicacion.modelo.HotelOfertaModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelOfertaService {

    public void upsertHotelOferta(HotelOfertaModel hotelOferta);
    public HotelOfertaModel findHotelOfertaById(String referencia);
    public boolean enTabla(String referencia);
    public void deleteByReferencia(String referencia);
    public List<HotelOfertaModel> findAllHotelOfertas();
}