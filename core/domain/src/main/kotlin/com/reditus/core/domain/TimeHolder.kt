package com.reditus.core.domain

import java.time.LocalDate
import java.time.LocalDateTime

interface TimeHolder {
    fun now(): Long
    fun nowLocalDate(): LocalDate
    fun nowLocalDateTime(): LocalDateTime
}