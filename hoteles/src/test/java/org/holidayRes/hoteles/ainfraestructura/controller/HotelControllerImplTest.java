package org.holidayRes.hoteles.ainfraestructura.controller;

import com.google.gson.Gson;
import org.holidayRes.hoteles.baplicacion.modelo.HotelModel;
import org.holidayRes.hoteles.baplicacion.service.HotelServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
class HotelControllerImplTest {

    @Autowired
    private MockMvc mockMvc;

    Gson gson = new Gson();

    @MockBean
    HotelServiceImpl hotelService;

    @Test
    void getHotelbyReferencia() throws Exception {

        HotelModel hotelModel = HotelModel.builder()
                .id("HOT-12345-123")
                .destino("Zaragoza")
                .numHabitaciones(10D)
                .precioHabitacion(100D)
                .precioTotal(1000D)
                .build();

        Mockito.when(hotelService.findHotelById("HOT-12345-123")).thenReturn(hotelModel);

        mockMvc.perform(get("/hoteles/HOT-12345-123").contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andDo(print());
    }
}