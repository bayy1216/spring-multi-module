package com.reditus.core.infrastructure

import com.reditus.core.domain.UuidHolder
import org.springframework.stereotype.Component

@Component
class SystemUuidHolder : UuidHolder {
    override fun generate(): String {
        return java.util.UUID.randomUUID().toString()
    }
}