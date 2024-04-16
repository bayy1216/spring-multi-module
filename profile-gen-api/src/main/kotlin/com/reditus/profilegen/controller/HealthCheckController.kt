package com.reditus.profilegen.controller

import com.reditus.core.domain.TimeHolder
import com.reditus.core.jwt.JwtProvider
import com.reditus.infrastructure.jpa.entity.User
import com.reditus.infrastructure.jpa.repository.UserJpaRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController(
    @Value("\${version}") private val applicationVersion: String,
    private val jwtProvider: JwtProvider,
    private val userJpaRepository: UserJpaRepository,
    private val timeHolder: TimeHolder,

) {

    @GetMapping("/ready")
    fun ready() : String {
        return "ready $applicationVersion"
    }

    @GetMapping("/live")
    fun live() : String {
        System.out.println("error")
        throw RuntimeException("error")
        return "error $applicationVersion"
    }

    @GetMapping("/user")
    fun user() : List<User> {
        return userJpaRepository.findAll()
    }

    @GetMapping("/user/create")
    fun createUser() : User {
        val user = User(nickname = "test")
        return userJpaRepository.save(user)
    }

    @GetMapping("/now")
    fun now() : Long {
        return timeHolder.now()
    }
}