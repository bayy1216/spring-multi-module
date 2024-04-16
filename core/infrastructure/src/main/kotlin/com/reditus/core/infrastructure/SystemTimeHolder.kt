package com.reditus.core.infrastructure

import com.reditus.core.domain.TimeHolder
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.LocalDateTime

@Component
internal class SystemTimeHolder : TimeHolder {
    override fun now(): Long {
        return System.currentTimeMillis()
    }

    override fun nowLocalDate(): LocalDate {
        return LocalDate.now()
    }

    override fun nowLocalDateTime(): LocalDateTime {
        return LocalDateTime.now()
    }
}