package org.holidayRes.vuelos;

import com.mongodb.MongoCredential;
import org.holidayRes.vuelos.cdominio.modelo.Vuelo;
import org.holidayRes.vuelos.cdominio.repository.VueloRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class VuelosAplicacion {
    public static void main(String[] args) {
        SpringApplication.run(VuelosAplicacion.class,args);
    }
}