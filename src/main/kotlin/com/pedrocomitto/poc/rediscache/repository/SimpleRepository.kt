package com.pedrocomitto.poc.rediscache.repository

import com.pedrocomitto.poc.rediscache.domain.SimpleEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SimpleRepository : CrudRepository<SimpleEntity, String>