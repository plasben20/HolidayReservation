package org.holidayRes.ainfraestructura.restclients;

import org.holidayRes.ainfraestructura.modelo.HotelResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// Step1: @FeignClient(name = "product-service", url="localhost:8001")
//@FeignClient(name = "product-service")
@FeignClient("hoteles")
public interface HotelesRestClient {

  @GetMapping("/hoteles")
  List<HotelResponse> getAll();

  @GetMapping("/hoteles/{referencia}")
  HotelResponse getById(@PathVariable String referencia);
}
