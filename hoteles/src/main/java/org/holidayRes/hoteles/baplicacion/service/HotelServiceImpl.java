package org.holidayRes.hoteles.baplicacion.service;

import org.holidayRes.hoteles.baplicacion.mapper.HotelMapper;
import org.holidayRes.hoteles.baplicacion.modelo.HotelModel;
import org.holidayRes.hoteles.cdominio.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelRepository hotelRepository;

    public void upsertHotel(HotelModel hotel) {
        hotelRepository.save(HotelMapper.INSTANCE.mapToHotelEntity(hotel));
    }

    public HotelModel findHotelById(String referencia){
        return HotelMapper.INSTANCE.mapToHotelModel(hotelRepository.findById(referencia).orElse(null));
    }

    public boolean enTabla(String referencia){ return (findHotelById(referencia)!=null); }

    public void deleteByReferencia(String referencia) {
        if (findHotelById(referencia)!=null)
            hotelRepository.deleteById(referencia);
    }

    public List<HotelModel> findAllHotels() {
        return HotelMapper.INSTANCE.mapToHotelListModel(hotelRepository.findAll());
    }
}