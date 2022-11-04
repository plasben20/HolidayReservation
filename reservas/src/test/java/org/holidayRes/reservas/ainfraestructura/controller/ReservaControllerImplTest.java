package org.holidayRes.reservas.ainfraestructura.controller;

import com.google.gson.Gson;
import org.holidayRes.reservas.ainfraestructura.dto.HotelOfertaRequest;
import org.holidayRes.reservas.ainfraestructura.dto.ReservaRequest;
import org.holidayRes.reservas.ainfraestructura.restclients.HotelReservaRestClient;
import org.holidayRes.reservas.ainfraestructura.restclients.VueloReservaRestClient;
import org.holidayRes.reservas.baplicacion.modelo.ReservaModel;
import org.holidayRes.reservas.baplicacion.service.ReservaServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("testReservas")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ReservaControllerImplTest {

    @Autowired
    private MockMvc mockMvc;

    Gson gson = new Gson();

    @MockBean
    HotelReservaRestClient hotelReservaRestClient;

    @MockBean
    VueloReservaRestClient vueloReservaRestClient;

    @MockBean
    ReservaServiceImpl reservaService;

    @Test
    void getReservabyReferencia() throws Exception {
        ReservaModel vueloOfertaModel = ReservaModel.builder()
                .id("RES-12345-123")
                .idVuelo("OVUE-12345-123")
                .idHotel("OHOT-12345-123")
                .build();

        Mockito.when(reservaService.findReservaById("RES-12345-123")).thenReturn(vueloOfertaModel);

        mockMvc.perform(get("/reservas/RES-12345-123").contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void postReserva() throws Exception {
        ReservaModel reservaModel = ReservaModel.builder()
                .id("RES-12345-123")
                .idVuelo("OVUE-12345-123")
                .idHotel("OHOT-12345-123")
                .build();
        ReservaRequest reservaRequest = ReservaRequest.builder()
                .id("RES-12345-123")
                .idVuelo("OVUE-12345-123")
                .idHotel("OHOT-12345-123")
                .build();

        HotelOfertaRequest hotelOfertaRequest = HotelOfertaRequest.builder()
                .id("OHOT-12345-123")
                .idHotel("HOT-12345-123")
                .numHabitaciones(10D)
                .precioHabitacion(100D)
                .precioTotal(1000D)
                .build();

        Mockito.when(reservaService.ComprobarIdentificadorVuelo(reservaRequest.getIdVuelo())).thenReturn(true);
        Mockito.when(reservaService.ComprobarIdentificadorHotel(reservaRequest.getIdHotel())).thenReturn(true);
        Mockito.when(reservaService.comprobacionesDatosReserva(any())).thenReturn(true);
        Mockito.when(reservaService.hayOfertaVuelo("OVUE-12345-123")).thenReturn(true);
        Mockito.when(reservaService.hayOfertaHotel("OHOT-12345-123")).thenReturn(true);
        Mockito.when(vueloReservaRestClient.getById("OVUE-12345-123")).thenReturn(any());
        Mockito.when(hotelReservaRestClient.getById("OHOT-12345-123")).thenReturn(any());
        mockMvc.perform(post("/reservas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(reservaRequest))
                ).andExpect(status().isCreated())
                .andDo(print());
    }
}