package com.pcad.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.awt.*;
import java.net.URI;

public class SwaggerConfig implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            // URL do Swagger UI
            String swaggerUrl = "http://localhost:8080/swagger-ui.html";

            // Abrir no navegador padrão
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(swaggerUrl));
            }
        } catch (Exception e) {
            System.err.println("Não foi possível abrir o Swagger automaticamente: " + e.getMessage());
        }
    }
}
