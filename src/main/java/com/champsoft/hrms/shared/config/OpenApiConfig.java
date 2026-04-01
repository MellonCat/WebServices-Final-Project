package com.champsoft.hrms.shared.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI hrmsOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("HRMS API")
                        .version("1.0.0")
                        .description("Hotel Reservation Management System - REST API")
                        .contact(new Contact().name("HRMS Team").email("n/a"))
                        .license(new License().name("Apache 2.0")));
    }
}