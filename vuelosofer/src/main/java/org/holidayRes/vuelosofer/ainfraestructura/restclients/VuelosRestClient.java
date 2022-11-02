package org.holidayRes.vuelosofer.ainfraestructura.restclients;

import org.holidayRes.vuelosofer.ainfraestructura.modelo.VueloResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Step1: @FeignClient(name = "product-service", url="localhost:8001")
//@FeignClient(name = "product-service")
@FeignClient("vuelos")
public interface VuelosRestClient {

  @GetMapping("/vuelos")
  List<VueloResponse> getAll();

  @GetMapping("/vuelos/{referencia}")
  VueloResponse getById(@PathVariable String referencia);
}
