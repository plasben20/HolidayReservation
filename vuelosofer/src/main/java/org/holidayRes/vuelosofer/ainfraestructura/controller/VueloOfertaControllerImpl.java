package org.holidayRes.vuelosofer.ainfraestructura.controller;

import org.holidayRes.vuelosofer.ainfraestructura.mapper.VueloOfertaRestMapper;
import org.holidayRes.vuelosofer.ainfraestructura.modelo.VueloOfertaResponse;
import org.holidayRes.vuelosofer.baplicacion.service.VueloOfertaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/vueloOfertasOfer")
public class VueloOfertaControllerImpl implements VueloOfertaController{

    @Autowired
    VueloOfertaServiceImpl vueloOfertaService;

    @GetMapping("/{referencia}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<VueloOfertaResponse> getVueloOfertabyReferencia(@PathVariable String referencia){
        VueloOfertaResponse vueloOferta = VueloOfertaRestMapper.INSTANCE.mapToVueloOfertaResponse(vueloOfertaService.findVueloOfertaById(referencia));
        if(vueloOferta==null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<VueloOfertaResponse>(vueloOferta, HttpStatus.OK);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<VueloOfertaResponse>> getAllinList() {
        List<VueloOfertaResponse> listaVueloOfertasOferta = VueloOfertaRestMapper.INSTANCE.mapToVueloOfertaListResponse(vueloOfertaService.findAllVueloOfertasOferta());
        if (listaVueloOfertasOferta.isEmpty()) return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<VueloOfertaResponse>>(listaVueloOfertasOferta,HttpStatus.OK);
    }

}