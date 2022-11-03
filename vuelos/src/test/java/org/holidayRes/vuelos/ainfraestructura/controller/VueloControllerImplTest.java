package org.holidayRes.vuelos.ainfraestructura.controller;

import com.google.gson.Gson;
import org.holidayRes.vuelos.baplicacion.modelo.VueloModel;
import org.holidayRes.vuelos.baplicacion.service.VueloServiceImpl;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
class VueloControllerImplTest {

    @Autowired
    private MockMvc mockMvc;

    Gson gson = new Gson();

    @MockBean
    VueloServiceImpl vueloService;

    @Test
    void getVuelobyReferencia() throws Exception {
        VueloModel hotelModel = VueloModel.builder()
                .id("VUE-12345-123")
                .origen("Madrid")
                .destino("Zaragoza")
                .numAsientos(10D)
                .precioAsiento(100D)
                .costeTotal(1000D)
                .build();

        Mockito.when(vueloService.findVueloById("VUE-12345-123")).thenReturn(hotelModel);

        mockMvc.perform(get("/vuelos/VUE-12345-123").contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andDo(print());
    }
}