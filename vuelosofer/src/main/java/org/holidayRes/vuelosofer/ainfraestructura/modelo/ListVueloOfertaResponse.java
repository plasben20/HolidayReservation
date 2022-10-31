package org.holidayRes.vuelosofer.ainfraestructura.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.holidayRes.vuelosofer.cdominio.modelo.VueloOferta;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ListVueloOfertaResponse {
    List<VueloOferta> vueloOfertasOfer;
}
