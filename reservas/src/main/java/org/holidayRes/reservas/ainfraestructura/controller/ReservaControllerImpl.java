package org.holidayRes.reservas.ainfraestructura.controller;

import feign.FeignException;
import org.holidayRes.reservas.ainfraestructura.dto.ReservaRequest;
import org.holidayRes.reservas.ainfraestructura.mapper.ReservaRestMapper;
import org.holidayRes.reservas.ainfraestructura.dto.ReservaResponse;
import org.holidayRes.reservas.baplicacion.service.ReservaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/reservas")
public class ReservaControllerImpl implements ReservaController{

    @Autowired
    ReservaServiceImpl reservaService;

    @GetMapping("/{referencia}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<ReservaResponse> getReservabyReferencia(@PathVariable String referencia){
        ReservaResponse reserva = ReservaRestMapper.INSTANCE.mapToReservaResponse(reservaService.findReservaById(referencia));
        if(reserva==null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<ReservaResponse>(reserva, HttpStatus.OK);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<ReservaResponse>> getAllinList() {
        List<ReservaResponse> listaReservas = ReservaRestMapper.INSTANCE.mapToReservaListResponse(reservaService.findAllReservas());
        if (listaReservas.isEmpty()) return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<ReservaResponse>>(listaReservas,HttpStatus.OK);
    }

    @Override
    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<?> postReserva(@RequestBody ReservaRequest request) {
        if (request==null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        // Comprobar que mete datos
        if (!reservaService.ComprobarIdentificadorVuelo(request.getIdVuelo()))
            return new ResponseEntity<>("Debe introducir un identificador de vuelo",HttpStatus.NO_CONTENT);
        if (!reservaService.ComprobarIdentificadorHotel(request.getIdHotel()))
            return new ResponseEntity<>("Debe introducir un identificador de hotel",HttpStatus.NO_CONTENT);
        if (!reservaService.comprobacionesDatosReserva(request.getId()))
            return new ResponseEntity<>("Id de la reserva debe tener el formato: 'RES-12345-123'", HttpStatus.CONFLICT);
        try {
            if (!reservaService.hayOfertaVuelo(request.getIdVuelo())) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            if (!reservaService.hayOfertaHotel(request.getIdHotel())) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (FeignException.NotFound fenf){
            return new ResponseEntity<>("No se ha encontrado una oferta de hotel o vuelo indicado", HttpStatus.NOT_FOUND);
        }
        reservaService.upsertReserva(ReservaRestMapper.INSTANCE.mapToReservaModel(request));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}