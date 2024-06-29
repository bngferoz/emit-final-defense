package com.feroz.apigateway.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.reactive.config.EnableWebFlux;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebFlux
public class GatewayCorsConfiguration {

    @Value("${spring.frontend.client}")
    private String[] clientList;

    private static final String ALLOWED_HEADERS = "*";
    List<String> ALLOWED_METHODS = Arrays.asList(HttpMethod.GET.name(), HttpMethod.POST.name(), HttpMethod.PUT.name(), HttpMethod.DELETE.name(), HttpMethod.OPTIONS.name());
    private static final String MAX_AGE = "7200"; //2 hours (2 * 60 * 60)

    @Bean
    public CorsWebFilter corsFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOriginPatterns(List.of("*"));
        corsConfig.setAllowedMethods(ALLOWED_METHODS);
        corsConfig.setMaxAge(Long.parseLong(MAX_AGE));
        corsConfig.addAllowedHeader(ALLOWED_HEADERS);
        corsConfig.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }
}