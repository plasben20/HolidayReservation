package org.holidayRes.hoteles.ainfraestructura.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.holidayRes.hoteles.ainfraestructura.modelo.HotelResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/hoteles")
public interface HotelController {

    @ApiOperation(value = "Obtenemos una hotel con su descuento")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Obtenemos correctamente la hotel"),
    })
    @GetMapping("/{referencia}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<HotelResponse> getHotelbyReferencia(@PathVariable String referencia);

    @ApiOperation(value = "Obtenemos una lista de hotels con descuentos")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Obtenemos correctamente la lista hotel"),
    })
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<HotelResponse>> getAllinList();
}