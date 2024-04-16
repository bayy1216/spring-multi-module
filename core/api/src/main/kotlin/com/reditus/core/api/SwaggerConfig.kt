package com.reditus.core.api


import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SwaggerConfig(
    @Value("\${swagger-config.title}") private val title: String,
    @Value("\${swagger-config.description}") private val description: String,
) {


    @Bean
    fun openAPI(): OpenAPI = OpenAPI()
        .components(components())
        .info(apiInfo())
        .addSecurityItem(SecurityRequirement().addList("bearer-key"))

    private fun components() = Components()
        .addSecuritySchemes("bearer-key", bearerJwtSecurityScheme())

    private fun bearerJwtSecurityScheme() = SecurityScheme()
        .type(SecurityScheme.Type.HTTP)
        .scheme("bearer")
        .bearerFormat("JWT")
        .description("JWT 인증을 위한 토큰을 입력하세요. (예: Bearer {token}에서 token만 입력)")

    private fun apiInfo() = Info()
        .title(title)
        .description(description)
        .version("1.0.0")
}