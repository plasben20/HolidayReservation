package org.holidayRes.vuelos.ainfraestructura.controller;

import org.holidayRes.vuelos.ainfraestructura.mapper.VueloRestMapper;
import org.holidayRes.vuelos.ainfraestructura.modelo.VueloResponse;
import org.holidayRes.vuelos.baplicacion.service.VueloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/vuelos")
public class VueloControllerImpl implements VueloController{

    @Autowired
    VueloServiceImpl vueloService;

    @GetMapping("/{referencia}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<VueloResponse> getVuelobyReferencia(@PathVariable String referencia){
        VueloResponse vuelo = VueloRestMapper.INSTANCE.mapToVueloResponse(vueloService.findVueloById(referencia));
        if(vuelo==null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<VueloResponse>(vuelo, HttpStatus.OK);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<VueloResponse>> getAllinList() {
        List<VueloResponse> listaVuelos = VueloRestMapper.INSTANCE.mapToVueloListResponse(vueloService.findAllVuelos());
        if (listaVuelos.isEmpty()) return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<VueloResponse>>(listaVuelos,HttpStatus.OK);
    }

}