package com.reditus.infrastructure.jpa.repository

import com.reditus.infrastructure.jpa.entity.User
import org.springframework.data.jpa.repository.JpaRepository


interface UserJpaRepository : JpaRepository<User, Long> {
}