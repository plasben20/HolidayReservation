package org.holidayRes.reservas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class ReservasAplicacion {
    public static void main(String[] args) {
        SpringApplication.run(ReservasAplicacion.class,args);
    }
}