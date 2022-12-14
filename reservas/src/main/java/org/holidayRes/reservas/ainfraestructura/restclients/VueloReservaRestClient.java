package org.holidayRes.reservas.ainfraestructura.restclients;

import org.holidayRes.reservas.ainfraestructura.dto.VueloOfertaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("vuelosofer")
public interface VueloReservaRestClient {
    @GetMapping("/vueloOfertas/{referencia}")
    VueloOfertaResponse getById(@PathVariable String referencia);
}
