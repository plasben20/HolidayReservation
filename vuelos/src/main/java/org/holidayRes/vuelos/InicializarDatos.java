package org.holidayRes.vuelos;

import org.holidayRes.vuelos.cdominio.modelo.Vuelo;
import org.holidayRes.vuelos.cdominio.repository.VueloRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;



@Configuration
@Profile("testVuelo")
class InicializarDatos {
    final String DEFAULT_IDENTIFIER = "HOT-123-450";
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
        };
    }
}
