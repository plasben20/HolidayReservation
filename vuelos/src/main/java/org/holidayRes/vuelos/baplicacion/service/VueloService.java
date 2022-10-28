package org.holidayRes.vuelos.baplicacion.service;

import org.holidayRes.vuelos.baplicacion.modelo.VueloModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VueloService {

    public void upsertVuelo(VueloModel vuelo);
    public VueloModel findVueloById(String referencia);
    public boolean enTabla(String referencia);
    public void deleteByReferencia(String referencia);
    public List<VueloModel> findAllVuelos();
}