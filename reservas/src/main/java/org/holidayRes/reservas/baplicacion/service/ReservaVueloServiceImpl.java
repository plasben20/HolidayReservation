package org.holidayRes.reservas.baplicacion.service;

import org.holidayRes.reservas.baplicacion.modelo.HotelModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Component
public class ReservaVueloServiceImpl {

    RestTemplate restTemplate;

    @Value("${app.environment.vuelos-host}")
    String vueloHost;

    public HotelModel buscarVueloPorId(String id_hotel) {
        String URI = "http://" + vueloHost + ":8081/vuelos/"+id_hotel;
        return restTemplate.getForObject(URI, HotelModel.class);
    }
}