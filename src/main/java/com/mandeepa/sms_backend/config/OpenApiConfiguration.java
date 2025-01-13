package com.mandeepa.sms_backend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Student Management System",
                description = "API Documentation",
                version = "1.0.0",
                contact = @Contact(
                        name = "Mandeepa De Silva",
                        email = "mandeepadesilva4.14@gmail.com"
                )
        ),
        servers = @Server(url = "http://localhost:8081/sms-backend/swagger-ui/index.html", description = "Local Server") // Add server info if necessary
)
@Configuration
@SecurityScheme(
        name = "Authorization",
        in = SecuritySchemeIn.HEADER,
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer",
        description = "Provide the Bearer access token in the Authorization header"
)
public class OpenApiConfiguration {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Student Management System")
                        .description("API Documentation")
                        .version("1.0.0")
                        .contact(new io.swagger.v3.oas.models.info.Contact()
                                .name("Mandeepa De Silva")
                                .email("mandeepadesilva4.14@gmail.com")));
    }
}
