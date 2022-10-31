package org.holidayRes.vuelosofer.ainfraestructura.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.holidayRes.vuelosofer.ainfraestructura.modelo.VueloOfertaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/vueloOfertasOfer")
public interface VueloOfertaController {

    @ApiOperation(value = "Obtenemos una vueloOferta con su descuento")
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
}