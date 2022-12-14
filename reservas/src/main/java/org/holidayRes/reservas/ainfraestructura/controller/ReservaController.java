package org.holidayRes.reservas.ainfraestructura.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.holidayRes.reservas.ainfraestructura.dto.ReservaRequest;
import org.holidayRes.reservas.ainfraestructura.dto.ReservaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/reservas")
public interface ReservaController {

    @ApiOperation(value = "Obtenemos una reserva con su descuento")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Obtenemos correctamente la reserva"),
    })
    @GetMapping("/{referencia}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<ReservaResponse> getReservabyReferencia(@PathVariable String referencia);

    @ApiOperation(value = "Obtenemos una lista de reservas con descuentos")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Obtenemos correctamente la lista reserva"),
    })
    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<?> postReserva(@RequestBody ReservaRequest request);
}