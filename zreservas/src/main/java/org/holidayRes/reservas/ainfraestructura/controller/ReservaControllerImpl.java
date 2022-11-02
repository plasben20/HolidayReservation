package org.holidayRes.reservas.ainfraestructura.controller;

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
    public ResponseEntity<ReservaResponse> postReserva(@RequestBody ReservaRequest request) {
        if (request==null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        if (!reservaService.hayOfertaVuelo(request.getIdVuelo())) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (!reservaService.hayOfertaHotel(request.getIdHotel())) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        reservaService.upsertReserva(ReservaRestMapper.INSTANCE.mapToReservaModel(request));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}