package com.jcardenas.superheros.domain.repositories

import com.jcardenas.superheros.domain.common.Result
import com.jcardenas.superheros.domain.entities.Hero
import kotlinx.coroutines.flow.Flow

interface HeroRepository {
    suspend fun getRemoteHero(id: Int): Result<Hero>
    suspend fun getHeroById(id: Int): Flow<Hero>
    suspend fun insert(hero: Hero)
}