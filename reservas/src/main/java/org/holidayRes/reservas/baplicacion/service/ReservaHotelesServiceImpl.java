package org.holidayRes.reservas.baplicacion.service;

import org.holidayRes.reservas.baplicacion.modelo.HotelModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Component
public class ReservaHotelesServiceImpl {

    RestTemplate restTemplate;

    @Value("${app.environment.hoteles-host}")
    String hotelHost;

    public HotelModel findAllReservas(String id_hotel) {
        String URI = "http://" + hotelHost + ":8081/hoteles/"+id_hotel;
        return restTemplate.getForObject(URI, HotelModel.class);
    }
}