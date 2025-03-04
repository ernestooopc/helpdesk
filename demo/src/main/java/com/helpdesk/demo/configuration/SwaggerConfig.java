package com.helpdesk.demo.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "API de HelpDesk",
        version = "1.0",
        description = "API para gestionar tickets de soporte",
        contact = @Contact(
            name = "Soporte Técnico",
            email = "soporte@empresa.com"
        )        
    )
)
public class SwaggerConfig {
}
