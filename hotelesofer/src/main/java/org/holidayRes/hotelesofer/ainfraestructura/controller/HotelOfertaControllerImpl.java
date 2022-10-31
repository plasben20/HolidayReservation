package org.holidayRes.hotelesofer.ainfraestructura.controller;

import org.holidayRes.hotelesofer.ainfraestructura.mapper.HotelOfertaRestMapper;
import org.holidayRes.hotelesofer.ainfraestructura.modelo.HotelOfertaResponse;
import org.holidayRes.hotelesofer.baplicacion.service.HotelOfertaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/hotelOfertaes")
public class HotelOfertaControllerImpl implements HotelOfertaController{

    @Autowired
    HotelOfertaServiceImpl hotelOfertaService;

    @GetMapping("/{referencia}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<HotelOfertaResponse> getHotelOfertabyReferencia(@PathVariable String referencia){
        HotelOfertaResponse hotelOferta = HotelOfertaRestMapper.INSTANCE.mapToHotelOfertaResponse(hotelOfertaService.findHotelOfertaById(referencia));
        if(hotelOferta==null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<HotelOfertaResponse>(hotelOferta, HttpStatus.OK);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<HotelOfertaResponse>> getAllinList() {
        List<HotelOfertaResponse> listaHotelOfertas = HotelOfertaRestMapper.INSTANCE.mapToHotelOfertaListResponse(hotelOfertaService.findAllHotelOfertas());
        if (listaHotelOfertas.isEmpty()) return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<HotelOfertaResponse>>(listaHotelOfertas,HttpStatus.OK);
    }

}