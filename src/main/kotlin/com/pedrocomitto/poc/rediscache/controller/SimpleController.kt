package com.pedrocomitto.poc.rediscache.controller

import com.pedrocomitto.poc.rediscache.domain.SimpleEntity
import com.pedrocomitto.poc.rediscache.repository.SimpleRepository
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/simple")
class SimpleController(
    private val simpleRepository: SimpleRepository
) {

    @PostMapping
    @CachePut(cacheNames = ["10s", "1m"])
    fun create(@RequestBody simpleEntity: SimpleEntity) {
        simpleRepository.save(simpleEntity)
    }

    @GetMapping("/10s")
    @Cacheable("10s")
    fun findAll10s(): MutableIterable<SimpleEntity> {
        println("entrei aqui")
        return simpleRepository.findAll();
    }

    @GetMapping("/1m")
    @Cacheable("1m")
    fun findAll1m(): MutableIterable<SimpleEntity> {
        println("entrei aqui")
        return simpleRepository.findAll()
    }

    @DeleteMapping
    @CacheEvict(cacheNames = ["10s", "1m"])
    fun deleteAll() {
        simpleRepository.deleteAll()
    }

}