package com.jose.hellospring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

// How to enable hot-swap
// https://stackoverflow.com/a/44095431/4086981
// Instead of step 3 follow this:
// https://youtrack.jetbrains.com/issue/IDEA-274903
// Note that in order for the auto swap to work yo need to do a build
// Ctrl + F9

public class Greeting(var id: Long, var content: String)

@SpringBootApplication
open class HelloSpringApplication

// TO generate an production standalone exe check this:
// mvn clean install
// https://frontbackend.com/spring-boot/create-spring-boot-runnable-jar-file

// Spring will scan all the components of sub-packages of demo package

@RestController
class GreetingsController {
	val template = "Hello %s!"
	val atomicLong = AtomicLong()

	@GetMapping("/greeting")
	fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String?): Greeting {
		return Greeting(atomicLong.getAndIncrement(), String.format(template, name))
	}

	// I can directly put controllers on the HelloSpringApplication but rather not.
	@GetMapping("/hello")
	fun hello(@RequestParam(value = "name", defaultValue = "World") name: String?): String? {
		return String.format("Hello %s! Fox News - Foolandia", name)
	}
}


fun main(args: Array<String>) {
	runApplication<HelloSpringApplication>(*args)
}
