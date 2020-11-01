package com.pedrocomitto.poc.rediscache.domain

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import java.io.Serializable

@RedisHash("simple")
data class SimpleEntity(
    @Id
    val param1: String,
    val param2: String
) : Serializable