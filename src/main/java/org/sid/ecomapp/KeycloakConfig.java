package org.sid.ecomapp;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.client.KeycloakClientRequestFactory;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {

    //si on ne souhaite pas utiliser le fichier keycloak.json, là, on impose que l'app aille rechercher la config dans l'application.properties
    @Bean
    KeycloakSpringBootConfigResolver configResolver(){
        return new KeycloakSpringBootConfigResolver();
    }

    @Bean
    KeycloakRestTemplate keycloakRestTemplate(KeycloakClientRequestFactory keycloakClientRequestFactory){
         return new KeycloakRestTemplate(keycloakClientRequestFactory);
    }
}
