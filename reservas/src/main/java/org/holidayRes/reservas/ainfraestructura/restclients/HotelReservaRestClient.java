package org.holidayRes.reservas.ainfraestructura.restclients;

import org.holidayRes.reservas.ainfraestructura.dto.HotelOfertaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("hotelesofer")
public interface HotelReservaRestClient {
    @GetMapping("/hotelOfertas/{referencia}")
    HotelOfertaResponse getById(@PathVariable String referencia);
}
