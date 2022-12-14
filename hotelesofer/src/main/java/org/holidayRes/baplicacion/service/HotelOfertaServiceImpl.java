package org.holidayRes.baplicacion.service;

import org.holidayRes.ainfraestructura.modelo.HotelOfertaRequest;
import org.holidayRes.ainfraestructura.restclients.HotelesRestClient;
import org.holidayRes.baplicacion.mapper.HotelOfertaMapper;
import org.holidayRes.baplicacion.modelo.HotelOfertaModel;
import org.holidayRes.cdominio.repository.HotelOfertaRepository;
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
        if (referencia==null) return false;
        return (hotelesRestClient.getById(referencia)!=null);
    }

    public void deleteByReferencia(String referencia) {
        if (findHotelOfertaById(referencia)!=null)
            hotelOfertaRepository.deleteById(referencia);
    }

    public List<HotelOfertaModel> findAllHotelOfertas() {
        return HotelOfertaMapper.INSTANCE.mapToHotelOfertaListModel(hotelOfertaRepository.findAll());
    }

    public boolean comprobacionesDatosReserva(HotelOfertaModel hotelOfertaModel) {
        return hotelOfertaModel.getId().matches("OHOT-\\d{5}-\\d{3}");
    }

    public boolean comprobarNulos(HotelOfertaRequest hotelOfertaRequest) {
        return (hotelOfertaRequest.getId()==null || hotelOfertaRequest.getIdHotel()==null);
    }
}