package org.holidayRes.ainfraestructura.controller;

import com.google.gson.Gson;
import feign.FeignException;
import org.holidayRes.ainfraestructura.mapper.VueloOfertaRestMapper;
import org.holidayRes.ainfraestructura.modelo.VueloOfertaRequest;
import org.holidayRes.ainfraestructura.restclients.VuelosRestClient;
import org.holidayRes.baplicacion.modelo.VueloOfertaModel;
import org.holidayRes.baplicacion.service.VueloOfertaServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
class VueloOfertaControllerImplTest {

    @Autowired
    private MockMvc mockMvc;

    Gson gson = new Gson();

    @MockBean
    VuelosRestClient vuelosRestClient;

    @MockBean
    VueloOfertaServiceImpl vueloOfertaService;

    @Test
    void getVueloOfertabyReferencia() throws Exception {
        VueloOfertaModel vueloOfertaModel = VueloOfertaModel.builder()
                .id("VUE-12345-123")
                .idVuelo("VUE-12345-123")
                .numAsientos(10D)
                .precioAsiento(100D)
                .costeTotal(1000D)
                .build();

        Mockito.when(vueloOfertaService.findVueloOfertaById("OVUE-12345-123")).thenReturn(vueloOfertaModel);

        mockMvc.perform(get("/vueloOfertas/OVUE-12345-123").contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void postOfertaVuelo() throws Exception {
        VueloOfertaModel vueloOfertaModel = VueloOfertaModel.builder()
                .id("OVUE-12345-123")
                .idVuelo("VUE-12345-123")
                .numAsientos(10D)
                .precioAsiento(100D)
                .costeTotal(1000D)
                .build();

        VueloOfertaRequest vueloOfertaRequest = VueloOfertaRequest.builder()
                .id("OVUE-12345-123")
                .idVuelo("VUE-12345-123")
                .numAsientos(10D)
                .precioAsiento(100D)
                .costeTotal(1000D)
                .build();

        //vueloOfertaService.upsertVueloOferta(vueloOfertaModel);
        //Mockito.when(vueloOfertaService.upsertVueloOferta(vueloOfertaModel)).thenReturn(any());
        Mockito.when(vueloOfertaService.comprobacionesDatosReserva(vueloOfertaModel)).thenReturn(true);
        Mockito.when(vueloOfertaService.existeVuelo("VUE-12345-123")).thenReturn(true);
        Mockito.when(vuelosRestClient.getById(any())).thenReturn(any());
        vueloOfertaService.upsertVueloOferta(vueloOfertaModel);
        mockMvc.perform(post("/vueloOfertas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(vueloOfertaRequest))
                ).andExpect(status().isCreated())
                .andDo(print());
    }
}