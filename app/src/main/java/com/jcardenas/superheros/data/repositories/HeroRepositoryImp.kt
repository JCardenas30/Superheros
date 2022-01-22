package com.jcardenas.superheros.data.repositories

import com.jcardenas.superheros.domain.entities.Hero
import com.jcardenas.superheros.domain.repositories.HeroRepository
import kotlinx.coroutines.flow.Flow
import com.jcardenas.superheros.domain.common.Result

class HeroRepositoryImp(
    private val localDataSource: HeroLocalDataSource,
    private val remoteDataSource: HeroRemoteDataSource
): HeroRepository {
    override suspend fun getRemoteHero(id: Int): Result<Hero> {
        return remoteDataSource.getHero(id)
    }

    override suspend fun getHeroById(id: Int): Flow<Hero> {
        return localDataSource.getHero(id)
    }

    override suspend fun insert(hero: Hero) {
        localDataSource.insert(hero)
    }
}