package com.project.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class ExampleController {

    @GetMapping("hello_world")
    fun hello() = "Hello World"
}