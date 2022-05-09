package com.proyectofinal.ProyectoFinal.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.GroupedOpenApi;

import static org.springdoc.core.Constants.ALL_PATTERN;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiMed() {
        return new OpenAPI()
                .info(new Info().title("API Atención Médica - Java Avanzado")
                        .description("API para atención médica. Proyecto final Java Avanzado Coderhouse")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Lucia Carmuega")
                                .url("https://github.com/lcarmuega/CH-JavaA")));

    }

    @Bean
    public GroupedOpenApi apiMedGroup(){
        return GroupedOpenApi.builder().group("apiMed")
                .addOpenApiCustomiser(openApi -> this.apiMed())
                .packagesToScan("package com.proyectofinal.ProyectoFinal.controllers")
                .build();
    }

    @Bean
    public GroupedOpenApi actuatorApi(OpenApiCustomiser openApiCustomiser,
                                      OperationCustomizer actuatorCustomizer,
                                      WebEndpointProperties webEndpointProperties,
                                      @Value("${springdoc.version") String version){
        return GroupedOpenApi.builder()
                .group("Actuator")
                .pathsToMatch(webEndpointProperties.getBasePath() + ALL_PATTERN)
                .addOpenApiCustomiser(openApiCustomiser)
                .addOpenApiCustomiser(openApi -> openApi.info(new Info().title("Actuator API").version(version)))
                .addOperationCustomizer(actuatorCustomizer)
                .build();
    }
}
