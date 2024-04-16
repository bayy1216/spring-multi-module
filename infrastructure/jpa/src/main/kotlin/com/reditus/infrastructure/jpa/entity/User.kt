package com.reditus.infrastructure.jpa.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
class User(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var nickname: String,

) {
}