package org.holidayRes.ainfraestructura.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.holidayRes.ainfraestructura.modelo.VueloOfertaRequest;
import org.holidayRes.ainfraestructura.modelo.VueloOfertaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/vueloOferta")
public interface VueloOfertaController {

    @ApiOperation(value = "Obtenemos una oferta de vuelo")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Obtenemos correctamente la vueloOferta"),
    })
    @GetMapping("/{referencia}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<VueloOfertaResponse> getVueloOfertabyReferencia(@PathVariable String referencia);

    @ApiOperation(value = "Obtenemos una lista de vueloOfertasOfer con descuentos")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Obtenemos correctamente la lista vueloOferta"),
    })
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<VueloOfertaResponse>> getAllinList();

    @ApiOperation(value = "Creamos una Oferta de vuelo")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Creamos correctamente la Oferta"),
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> postOfertaVuelo(@RequestBody VueloOfertaRequest vueloOfertaRequest);
}