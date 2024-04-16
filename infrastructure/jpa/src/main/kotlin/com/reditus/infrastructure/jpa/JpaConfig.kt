package com.reditus.infrastructure.jpa

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EnableJpaAuditing
@EntityScan(basePackages = ["com.reditus.infrastructure.jpa.entity"])
@EnableJpaRepositories(basePackages = ["com.reditus.infrastructure.jpa.repository"])
class JpaConfig {
}