package com.hiberus.ms.app.item.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "text")
@Getter
@Setter
@NoArgsConstructor
public class TextConfiguration {

    private String textOne;
    private String textTwo;
    private String textThree;
}
