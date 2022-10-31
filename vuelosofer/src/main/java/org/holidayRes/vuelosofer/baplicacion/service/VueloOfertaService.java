package org.holidayRes.vuelosofer.baplicacion.service;

import org.holidayRes.vuelosofer.baplicacion.modelo.VueloOfertaModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VueloOfertaService {

    public void upsertVueloOferta(VueloOfertaModel vueloOferta);
    public VueloOfertaModel findVueloOfertaById(String referencia);
    public boolean enTabla(String referencia);
    public void deleteByReferencia(String referencia);
    public List<VueloOfertaModel> findAllVueloOfertasOferta();
}