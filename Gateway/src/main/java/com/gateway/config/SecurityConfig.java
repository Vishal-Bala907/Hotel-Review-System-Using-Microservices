package com.gateway.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity.OAuth2ResourceServerSpec;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.web.server.SecurityWebFilterChain; 

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
        httpSecurity
            .authorizeExchange(exchanges -> exchanges
                .anyExchange().authenticated()) // Ensure all exchanges are authenticated
            .oauth2Client(withDefaults()) // Default settings for OAuth2 client
            .oauth2ResourceServer(OAuth2ResourceServerSpec::jwt); // Configures JWT-based OAuth2 resource server

        return httpSecurity.build();
    }
    @Bean
    public ReactiveJwtDecoder jwtDecoder() {
        // Replace with your actual Okta OAuth2 issuer URL
        String oktaIssuerUri = "https://dev-82486934.okta.com/oauth2/default/v1/keys"; 
        return NimbusReactiveJwtDecoder.withJwkSetUri(oktaIssuerUri).build();
    }

}
