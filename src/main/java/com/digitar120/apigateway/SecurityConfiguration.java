package com.digitar120.apigateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
// Intercepta todas las llamadas a la API Gateway y las pasa por OAuth2 para verificarlas.
public class SecurityConfiguration {

    @Bean(name = "apiGatewayBean")
    public SecurityWebFilterChain SecurityWebFilterChain(ServerHttpSecurity httpSecurity) {
        httpSecurity.authorizeExchange(exchanges -> exchanges.anyExchange().authenticated() )
                .oauth2Login(Customizer.withDefaults());

        httpSecurity.csrf().disable();

        return httpSecurity.build();
    }
}
