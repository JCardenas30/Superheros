package com.jcardenas.superheros.domain.repositories

import androidx.lifecycle.LiveData
import com.jcardenas.superheros.domain.common.Result
import com.jcardenas.superheros.domain.entities.Hero
import kotlinx.coroutines.flow.Flow

interface HeroRepository {
    fun getRemoteHero(id: Int, response: (result: Result<Hero>) -> Unit)
    suspend fun getHeroById(id: Int): Flow<Hero>
    suspend fun insert(heros: List<Hero>)
}