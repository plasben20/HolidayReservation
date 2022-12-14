package org.holidayRes.ainfraestructura.controller;

import feign.FeignException;

import org.holidayRes.ainfraestructura.mapper.VueloOfertaRestMapper;
import org.holidayRes.ainfraestructura.modelo.VueloOfertaRequest;
import org.holidayRes.ainfraestructura.modelo.VueloOfertaResponse;
import org.holidayRes.baplicacion.service.VueloOfertaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/vueloOfertas")
public class VueloOfertaControllerImpl implements VueloOfertaController{

    @Autowired
    VueloOfertaServiceImpl vueloOfertaService;

    @GetMapping("/{referencia}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<VueloOfertaResponse> getVueloOfertabyReferencia(@PathVariable String referencia){
        if (referencia.equals(null)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        VueloOfertaResponse vueloOferta = VueloOfertaRestMapper.INSTANCE.mapToVueloOfertaResponse(vueloOfertaService.findVueloOfertaById(referencia));
        if(vueloOferta==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(vueloOferta, HttpStatus.OK);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<VueloOfertaResponse>> getAllinList() {
        List<VueloOfertaResponse> listaVueloOfertasOferta = VueloOfertaRestMapper.INSTANCE.mapToVueloOfertaListResponse(vueloOfertaService.findAllVueloOfertasOferta());
        if (listaVueloOfertasOferta.isEmpty()) return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(listaVueloOfertasOferta,HttpStatus.OK);
    }

    @Override
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> postOfertaVuelo(VueloOfertaRequest vueloOfertaRequest) {
        // Controlar que la referencia este en la tabla vuelo
        if (vueloOfertaService.comprobarNulos(vueloOfertaRequest))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        if (!vueloOfertaService.comprobacionesDatosReserva(VueloOfertaRestMapper.INSTANCE.mapToVueloOfertaModel(vueloOfertaRequest)))
            return new ResponseEntity<>("Id de Oferta de vuelo debe tener el formato: 'OVUE-12345-123'", HttpStatus.CONFLICT);
        try {
            if (!vueloOfertaService.existeVuelo(vueloOfertaRequest.getIdVuelo()))
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (FeignException.NotFound fenf){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        vueloOfertaService.upsertVueloOferta(VueloOfertaRestMapper.INSTANCE.mapToVueloOfertaModel(vueloOfertaRequest));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}