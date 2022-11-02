package org.holidayRes.reservas.ainfraestructura.restclients;

import org.holidayRes.reservas.ainfraestructura.dto.HotelOfertaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("vuelosofer")
public interface VueloReservaRestClient {
    @GetMapping("/vueloOfertas/{referencia}")
    VueloReservaRestClient getById(@PathVariable String referencia);
}
