package org.holidayRes.ainfraestructura.controller;

import com.google.gson.Gson;
import org.holidayRes.ainfraestructura.modelo.HotelOfertaRequest;
import org.holidayRes.ainfraestructura.restclients.HotelesRestClient;
import org.holidayRes.baplicacion.modelo.HotelOfertaModel;
import org.holidayRes.baplicacion.service.HotelOfertaServiceImpl;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
class HotelOfertaControllerImplTest {

    @Autowired
    private MockMvc mockMvc;

    Gson gson = new Gson();

    @MockBean
    HotelesRestClient vuelosRestClient;

    @MockBean
    HotelOfertaServiceImpl vueloOfertaService;

    @Test
    void getHotelOfertabyReferencia() throws Exception {
        HotelOfertaModel vueloOfertaModel = HotelOfertaModel.builder()
                .id("OHOT-12345-123")
                .idHotel("HOT-12345-123")
                .numHabitaciones(10D)
                .precioHabitacion(100D)
                .precioTotal(1000D)
                .build();

        Mockito.when(vueloOfertaService.findHotelOfertaById("OHOT-12345-123")).thenReturn(vueloOfertaModel);

        mockMvc.perform(get("/hotelOfertas/OHOT-12345-123").contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void postOfertaHotel() throws Exception {
        HotelOfertaModel hotelOfertaModel = HotelOfertaModel.builder()
                .id("OHOT-12345-123")
                .idHotel("HOT-12345-123")
                .numHabitaciones(10D)
                .precioHabitacion(100D)
                .precioTotal(1000D)
                .build();

        HotelOfertaRequest hotelOfertaRequest = HotelOfertaRequest.builder()
                .id("OHOT-12345-123")
                .idHotel("HOT-12345-123")
                .numHabitaciones(10D)
                .precioHabitacion(100D)
                .precioTotal(1000D)
                .build();

        //vueloOfertaService.upsertVueloOferta(vueloOfertaModel);
        //Mockito.when(vueloOfertaService.upsertVueloOferta(vueloOfertaModel)).thenReturn(any());
        Mockito.when(vueloOfertaService.comprobacionesDatosReserva(hotelOfertaModel)).thenReturn(true);
        Mockito.when(vueloOfertaService.existeHotel("HOT-12345-123")).thenReturn(true);
        Mockito.when(vuelosRestClient.getById(any())).thenReturn(any());
        vueloOfertaService.upsertHotelOferta(hotelOfertaModel);
        mockMvc.perform(post("/hotelOfertas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(hotelOfertaRequest))
                ).andExpect(status().isCreated())
                .andDo(print());
    }
}