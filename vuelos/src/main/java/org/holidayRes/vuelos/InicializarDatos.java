package org.holidayRes.vuelos;

import lombok.extern.slf4j.Slf4j;
import org.holidayRes.vuelos.cdominio.modelo.Vuelo;
import org.holidayRes.vuelos.cdominio.repository.VueloRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class InicializarDatos {
    final String DEFAULT_IDENTIFIER = "VUE-123-450";
    final String DEFAULT_IDENTIFIER2 = "VUE-123-456";
    final String DEFAULT_IDENTIFIER3 = "VUE-00001-001";
    final String DEFAULT_ORIGEN = "Zaragoza";
    final String DEFAULT_DESTINO = "MADRID";
    final Double DEFAULT_NUMERO_ASIENTOS = 250d;
    final Double DEFAULT_PRECIO_ASIENTO = 80.00D;
    final Double DEFAULT_COSTE_TOTAL = 1200D;

    final String ip = "localhost";
    final String port = "27017";
    final String database = "vuelosdb";
    final String username = "benedi";
    final String password = "benedi";

    @Bean
    CommandLineRunner initDatabase(VueloRepository repository) {
        return args -> {
            //MongoCredential.createCredential(username,database,password.toCharArray());
            repository.save(new Vuelo(DEFAULT_IDENTIFIER, DEFAULT_ORIGEN, DEFAULT_DESTINO, DEFAULT_NUMERO_ASIENTOS, DEFAULT_PRECIO_ASIENTO, DEFAULT_COSTE_TOTAL));
            repository.save(new Vuelo(DEFAULT_IDENTIFIER2, DEFAULT_ORIGEN, DEFAULT_DESTINO, DEFAULT_NUMERO_ASIENTOS, DEFAULT_PRECIO_ASIENTO, DEFAULT_COSTE_TOTAL));
            log.info(String.valueOf(repository.findById(DEFAULT_IDENTIFIER)));
            log.info(String.valueOf(repository.findById(DEFAULT_IDENTIFIER).get().getDestino()));
        };
    }
}
