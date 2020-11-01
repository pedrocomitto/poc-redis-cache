package com.pedrocomitto.poc.rediscache.config

import org.springframework.cache.CacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.cache.RedisCacheWriter
import org.springframework.data.redis.connection.RedisConnectionFactory
import java.time.Duration

@Configuration
class CacheConfiguration(
    private val redisConnectionFactory: RedisConnectionFactory
) {

    @Bean
    fun cacheManager(): CacheManager {
        val redisCacheWriter = RedisCacheWriter.lockingRedisCacheWriter(redisConnectionFactory)

        return RedisCacheManager.RedisCacheManagerBuilder
                .fromCacheWriter(redisCacheWriter)
                .disableCreateOnMissingCache()
                .withCacheConfiguration(
                    "10s",
                    RedisCacheConfiguration.defaultCacheConfig()
                        .entryTtl(Duration.ofSeconds(10))
                )
                .withCacheConfiguration(
                    "1m",
                    RedisCacheConfiguration.defaultCacheConfig()
                        .entryTtl(Duration.ofMinutes(1))
                ).build()
    }
}