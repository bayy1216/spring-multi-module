package com.reditus.core.jwt

import com.reditus.core.common.exception.NotAuthorizedException
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtProvider(
    @Value("\${jwt.secret}") val secret: String,

    @Value("\${jwt.accessTokenExpireTime}") private val expiration: Long,
    @Value("\${jwt.refreshTokenExpireTime}") private val refreshExpiration: Long,
) {
    private val key by lazy { Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret)) }

    fun createToken(jwtUser: JwtUser) : JwtToken {
        val accessToken = generateToken(jwtUser, isAccessToken = true)
        val refreshToken = generateToken(jwtUser, isAccessToken = false)
        return JwtToken(accessToken, refreshToken)
    }

    private fun generateToken(jwtUser: JwtUser, isAccessToken: Boolean): String{
        val now = Date()
        val expirationTime = if(isAccessToken) now.time + expiration else now.time + refreshExpiration
        return Jwts.builder()
            .subject(jwtUser.id.toString())
            .claim(ROLE, jwtUser.roles)
            .claim(IS_ACCESS, isAccessToken)
            .issuedAt(now)
            .expiration(Date(expirationTime))
            .signWith(key, Jwts.SIG.HS256)
            .compact()
    }

    fun extractJwtUser(rawToken: String): JwtUser{
        val claims = extractClaims(rawToken)
        return JwtUser(
            id = claims.subject.toLong(),
            roles = claims[ROLE] as? List<String> ?: emptyList()
        )
    }

    fun validateToken(rawToken: String, isAccessToken:Boolean = true) : Boolean {
        val claims = extractClaims(rawToken)
        val expiration = claims.expiration

        return expiration.after(Date()) && claims[IS_ACCESS] == isAccessToken
    }

    private fun extractClaims(rawToken: String): Claims {
        try{
            return Jwts.parser().verifyWith(key).build().parse(rawToken).payload as Claims
        }catch (e: Exception){
            throw NotAuthorizedException("토큰이 유효하지 않습니다.")
        }
    }

    companion object {
        const val ROLE = "role"
        const val IS_ACCESS = "isAccess"
    }
}