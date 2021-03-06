package com.jcardenas.superheros.data.repositories

import com.jcardenas.superheros.domain.entities.Hero
import kotlinx.coroutines.flow.Flow

interface HeroLocalDataSource {
    suspend fun insert(heros: List<Hero>)
    suspend fun getHero(heroId: Int): Flow<Hero>
}