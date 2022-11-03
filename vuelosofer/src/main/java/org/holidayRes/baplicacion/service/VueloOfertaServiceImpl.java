package org.holidayRes.baplicacion.service;

import org.holidayRes.ainfraestructura.modelo.VueloOfertaRequest;
import org.holidayRes.ainfraestructura.restclients.VuelosRestClient;
import org.holidayRes.baplicacion.mapper.VueloOfertaMapper;
import org.holidayRes.baplicacion.modelo.VueloOfertaModel;
import org.holidayRes.cdominio.repository.VueloOfertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueloOfertaServiceImpl implements VueloOfertaService {
    @Autowired
    VueloOfertaRepository vueloOfertaRepository;

    @Autowired
    VuelosRestClient vuelosRestClient;

    public void upsertVueloOferta(VueloOfertaModel vueloOferta) {
        vueloOfertaRepository.save(VueloOfertaMapper.INSTANCE.mapToVueloOfertaEntity(vueloOferta));
    }

    public VueloOfertaModel findVueloOfertaById(String referencia){
        return VueloOfertaMapper.INSTANCE.mapToVueloOfertaModel(vueloOfertaRepository.findById(referencia).orElse(null));
    }

    public boolean existeVuelo(String referencia){
        return (vuelosRestClient.getById(referencia)!=null);
    }

    public boolean enTabla(String referencia){ return (findVueloOfertaById(referencia)!=null); }

    public void deleteByReferencia(String referencia) {
        if (findVueloOfertaById(referencia)!=null)
            vueloOfertaRepository.deleteById(referencia);
    }

    public List<VueloOfertaModel> findAllVueloOfertasOferta() {
        return VueloOfertaMapper.INSTANCE.mapToVueloOfertaListModel(vueloOfertaRepository.findAll());
    }

    public boolean comprobacionesDatosReserva(VueloOfertaModel vueloOfertaModel) {
        return (vueloOfertaModel.getId().matches("OVUE-\\d{5}-\\d{3}"));
    }

    public boolean comprobarNulos(VueloOfertaRequest vueloOfertaRequest) {
        return (vueloOfertaRequest.getId()==null || vueloOfertaRequest.getIdVuelo()==null);
    }
}