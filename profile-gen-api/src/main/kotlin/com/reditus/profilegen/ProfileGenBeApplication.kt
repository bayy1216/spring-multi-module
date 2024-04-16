package com.reditus.profilegen

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan


@ComponentScan(basePackages = ["com.reditus"])
@SpringBootApplication
class ProfileGenBeApplication

fun main(args: Array<String>) {
    runApplication<ProfileGenBeApplication>(*args)
}
