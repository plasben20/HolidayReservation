package org.holidayRes.hoteles.baplicacion.service;

import org.holidayRes.hoteles.baplicacion.modelo.HotelModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {

    public void upsertHotel(HotelModel hotel);
    public HotelModel findHotelById(String referencia);
    public boolean enTabla(String referencia);
    public void deleteByReferencia(String referencia);
    public List<HotelModel> findAllHotels();
}