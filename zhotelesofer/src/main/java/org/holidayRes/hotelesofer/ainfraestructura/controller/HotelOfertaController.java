package org.holidayRes.hotelesofer.ainfraestructura.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.holidayRes.hotelesofer.ainfraestructura.modelo.HotelOfertaRequest;
import org.holidayRes.hotelesofer.ainfraestructura.modelo.HotelOfertaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/hotelOfertas")
public interface HotelOfertaController {

    @ApiOperation(value = "Obtenemos una hotelOferta con su descuento")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Obtenemos correctamente la hotelOferta"),
    })
    @GetMapping("/{referencia}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<HotelOfertaResponse> getHotelOfertabyReferencia(@PathVariable String referencia);

    @ApiOperation(value = "Obtenemos una lista de hotelOfertas con descuentos")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Obtenemos correctamente la lista hotelOferta"),
    })
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<HotelOfertaResponse>> getAllinList();

    @ApiOperation(value = "Creamos una Oferta de Hotel")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Creamos correctamente la Oferta"),
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> postOfertaHotel(HotelOfertaRequest hotelOfertaRequest);
}