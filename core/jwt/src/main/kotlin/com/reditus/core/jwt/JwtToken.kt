package com.reditus.core.jwt

data class JwtToken(
    val accessToken: String,
    val refreshToken: String
)
