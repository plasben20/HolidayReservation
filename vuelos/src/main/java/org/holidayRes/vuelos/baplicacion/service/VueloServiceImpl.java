package org.holidayRes.vuelos.baplicacion.service;

import org.holidayRes.vuelos.baplicacion.mapper.VueloMapper;
import org.holidayRes.vuelos.baplicacion.modelo.VueloModel;
import org.holidayRes.vuelos.cdominio.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueloServiceImpl implements VueloService {
    @Autowired
    VueloRepository vueloRepository;

    public void upsertVuelo(VueloModel vuelo) {
        vueloRepository.save(VueloMapper.INSTANCE.mapToVueloEntity(vuelo));
    }

    public VueloModel findVueloById(String referencia){
        return VueloMapper.INSTANCE.mapToVueloModel(vueloRepository.findById(referencia).orElse(null));
    }

    public boolean enTabla(String referencia){ return (findVueloById(referencia)!=null); }

    public void deleteByReferencia(String referencia) {
        if (findVueloById(referencia)!=null)
            vueloRepository.deleteById(referencia);
    }

    public List<VueloModel> findAllVuelos() {
        return VueloMapper.INSTANCE.mapToVueloListModel(vueloRepository.findAll());
    }
}