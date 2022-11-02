package org.holidayRes.vuelosofer.baplicacion.service;

import org.holidayRes.vuelosofer.ainfraestructura.restclients.VuelosRestClient;
import org.holidayRes.vuelosofer.baplicacion.mapper.VueloOfertaMapper;
import org.holidayRes.vuelosofer.baplicacion.modelo.VueloOfertaModel;
import org.holidayRes.vuelosofer.cdominio.repository.VueloOfertaRepository;
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
}