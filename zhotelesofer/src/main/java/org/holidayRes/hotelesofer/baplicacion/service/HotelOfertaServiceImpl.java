package org.holidayRes.hotelesofer.baplicacion.service;

import org.holidayRes.hotelesofer.ainfraestructura.restclients.HotelesRestClient;
import org.holidayRes.hotelesofer.baplicacion.mapper.HotelOfertaMapper;
import org.holidayRes.hotelesofer.baplicacion.modelo.HotelOfertaModel;
import org.holidayRes.hotelesofer.cdominio.repository.HotelOfertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelOfertaServiceImpl implements HotelOfertaService {
    @Autowired
    HotelOfertaRepository hotelOfertaRepository;

    @Autowired
    HotelesRestClient hotelesRestClient;

    public void upsertHotelOferta(HotelOfertaModel hotelOferta) {
        hotelOfertaRepository.save(HotelOfertaMapper.INSTANCE.mapToHotelOfertaEntity(hotelOferta));
    }

    public HotelOfertaModel findHotelOfertaById(String referencia){
        return HotelOfertaMapper.INSTANCE.mapToHotelOfertaModel(hotelOfertaRepository.findById(referencia).orElse(null));
    }

    public boolean enTabla(String referencia){ return (findHotelOfertaById(referencia)!=null); }

    public boolean existeHotel(String referencia){
        return (hotelesRestClient.getById(referencia)!=null);
    }

    public void deleteByReferencia(String referencia) {
        if (findHotelOfertaById(referencia)!=null)
            hotelOfertaRepository.deleteById(referencia);
    }

    public List<HotelOfertaModel> findAllHotelOfertas() {
        return HotelOfertaMapper.INSTANCE.mapToHotelOfertaListModel(hotelOfertaRepository.findAll());
    }
}