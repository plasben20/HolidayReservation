package org.holidayRes.hotelesofer.ainfraestructura.controller;

import feign.FeignException;
import org.holidayRes.hotelesofer.ainfraestructura.mapper.HotelOfertaRestMapper;
import org.holidayRes.hotelesofer.ainfraestructura.modelo.HotelOfertaRequest;
import org.holidayRes.hotelesofer.ainfraestructura.modelo.HotelOfertaResponse;
import org.holidayRes.hotelesofer.baplicacion.service.HotelOfertaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/hotelOfertas")
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
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> postOfertaHotel(HotelOfertaRequest hotelOfertaRequest) {
        // Controlar que la referencia este en la tabla hotel
        if(!(hotelOfertaRequest.getId().matches("OHOT-[0-9]{5}-[0-9]{3}"))) return new ResponseEntity("Id de Oferta de habitaciones de Hotel debe tener el formato: 'OHOT-12345-123'", HttpStatus.CONFLICT);
        try {
            if (hotelOfertaService.existeHotel(hotelOfertaRequest.getIdHotel())==false) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (FeignException.NotFound fenf){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        hotelOfertaService.upsertHotelOferta(HotelOfertaRestMapper.INSTANCE.mapToHotelOfertaModel(hotelOfertaRequest));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}