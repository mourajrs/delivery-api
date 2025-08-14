package com.deliverytech.delivery_api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.Map;

@CrossOrigin(origins = "*")
 
@RestController
@Tag(name = "Health Check", description = "Verifica o status da API e exibe informações do sistema")
public class HealthController {

    @Operation(
        summary = "Verifica o status da API",
        description = "Retorna informações básicas como status, timestamp, versão do Java e nome do serviço.",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "API em funcionamento",
                content = @Content(mediaType = "application/json")
            )
        }
    )
    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of(
            "status", "UP",
            "timestamp", LocalDateTime.now().toString(),
            "service", "Delivery API",
            "javaVersion", System.getProperty("java.version")
        );
    }

    @Operation(
        summary = "Informações da aplicação",
        description = "Retorna informações detalhadas da aplicação como nome, versão, desenvolvedor e frameworks.",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Informações da aplicação retornadas com sucesso",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = AppInfo.class)
                )
            )
        }
    )
    @GetMapping("/info")
    public AppInfo info() {
        return new AppInfo(
            "Delivery Tech API",
            "1.0.0",
            "Anderson Buenos",
            "JDK 17",
            "Spring Boot 3.5.3"
        );
    }

    public record AppInfo(
        String application,
        String version,
        String developer,
        String javaVersion,
        String framework
    ) {}
}
