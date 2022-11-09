package org.holidayRes.vuelos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class VuelosAplicacion {
    public static void main(String[] args) {
        SpringApplication.run(VuelosAplicacion.class,args);
    }
}