package com.jose.hellospring.controller

import com.jose.hellospring.Greeting
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

class Foo(val name: String, val age: Int)

// Spring will scan all the components of sub-packages of demo package.
@RestController
class FooController {
    @GetMapping("/foo")
    fun greeting(
        @RequestParam(value = "name", defaultValue = "Jose") name: String,
        @RequestParam(value = "age", defaultValue = "24") age: String
    ): Foo {
        return Foo(name, age.toInt())
    }
}