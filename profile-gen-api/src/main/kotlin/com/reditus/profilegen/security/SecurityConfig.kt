package com.reditus.profilegen.security

import com.reditus.core.api.ErrorResponse
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
@Configuration
class SecurityConfig {
    private val log = LoggerFactory.getLogger(this::class.java)

    @Bean
    fun configure(http: HttpSecurity): SecurityFilterChain {
        http.csrf{
            it.disable()
        }
        http.sessionManagement {
            it.disable()
        }

        http.authorizeHttpRequests {
            it.anyRequest().permitAll()
        }

        http.exceptionHandling {
            it.authenticationEntryPoint { request, response, authException ->
                log.debug("Authentication exception", request, authException)
                val errorResponse = ErrorResponse(
                    message = authException.message ?: "Unauthorized",
                    code = "UNAUTHORIZED"
                )
                response.status = 401
                response.writer.write(errorResponse.toString())
            }
            it.accessDeniedHandler { request, response, accessDeniedException ->
                log.debug("Access denied exception", request, accessDeniedException)
                val errorResponse = ErrorResponse(
                    message = accessDeniedException.message ?: "Forbidden",
                    code = "FORBIDDEN"
                )
                response.status = 403
                response.writer.write(errorResponse.toString())
            }
        }
        return http.build()

    }

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }
}