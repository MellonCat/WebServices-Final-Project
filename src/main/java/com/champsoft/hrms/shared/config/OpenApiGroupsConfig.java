package com.champsoft.hrms.shared.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiGroupsConfig {

    @Bean
    GroupedOpenApi guestsApi() {
        return GroupedOpenApi.builder().group("guests").pathsToMatch("/api/guests/**").build();
    }

    @Bean
    GroupedOpenApi roomsApi() {
        return GroupedOpenApi.builder().group("rooms").pathsToMatch("/api/rooms/**").build();
    }

    @Bean
    GroupedOpenApi paymentApi() {
        return GroupedOpenApi.builder().group("payment").pathsToMatch("/api/payment/**").build();
    }

    @Bean
    GroupedOpenApi bookingsApi() {
        return GroupedOpenApi.builder().group("bookings").pathsToMatch("/api/bookings/**").build();
    }
}
