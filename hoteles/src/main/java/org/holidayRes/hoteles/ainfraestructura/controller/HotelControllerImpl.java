package org.holidayRes.hoteles.ainfraestructura.controller;

import org.holidayRes.hoteles.ainfraestructura.mapper.HotelRestMapper;
import org.holidayRes.hoteles.ainfraestructura.modelo.HotelResponse;
import org.holidayRes.hoteles.baplicacion.service.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/hoteles")
public class HotelControllerImpl implements HotelController{

    @Autowired
    HotelServiceImpl hotelService;

    @GetMapping("/{referencia}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<HotelResponse> getHotelbyReferencia(@PathVariable String referencia){
        HotelResponse hotel = HotelRestMapper.INSTANCE.mapToHotelResponse(hotelService.findHotelById(referencia));
        if(hotel==null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<HotelResponse>(hotel, HttpStatus.OK);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<HotelResponse>> getAllinList() {
        List<HotelResponse> listaHotels = HotelRestMapper.INSTANCE.mapToHotelListResponse(hotelService.findAllHotels());
        if (listaHotels.isEmpty()) return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<HotelResponse>>(listaHotels,HttpStatus.OK);
    }

}