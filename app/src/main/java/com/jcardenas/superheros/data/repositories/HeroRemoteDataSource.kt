package com.jcardenas.superheros.data.repositories

import com.jcardenas.superheros.domain.common.Result
import com.jcardenas.superheros.domain.entities.Hero

interface HeroRemoteDataSource {

    suspend fun getHero(heroId: Int): Result<Hero>
}