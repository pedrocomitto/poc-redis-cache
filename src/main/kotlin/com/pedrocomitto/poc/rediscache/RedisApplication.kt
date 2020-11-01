package com.pedrocomitto.poc.rediscache

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@SpringBootApplication
class RedisApplication

fun main(args: Array<String>) {
	runApplication<RedisApplication>(*args)
}
