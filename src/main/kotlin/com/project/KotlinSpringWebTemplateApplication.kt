package com.project

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringWebTemplateApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringWebTemplateApplication>(*args)
}
