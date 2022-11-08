package org.holidayRes.vuelos.ainfraestructura.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.holidayRes.vuelos.ainfraestructura.modelo.VueloResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface VueloController {

    @ApiOperation(value = "Obtenemos una vuelo con su descuento")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Obtenemos correctamente la vuelo"),
    })
    @GetMapping("/{referencia}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<VueloResponse> getVuelobyReferencia(@PathVariable String referencia);

    @ApiOperation(value = "Obtenemos una lista de vuelos con descuentos")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Obtenemos correctamente la lista vuelo"),
    })
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<VueloResponse>> getAllinList();
}