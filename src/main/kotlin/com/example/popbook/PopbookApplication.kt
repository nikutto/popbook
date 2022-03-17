package com.example.popbook

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class PopbookApplication

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<PopbookApplication>(*args)
}
