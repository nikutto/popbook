package com.example.popbook

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "appconfig")
data class ServiceConfiguration(
    val updateIntervalMinutes: Int,
    val poppingHours: Int,
    val expireHours: Int,
    val nPage: Int,
)
