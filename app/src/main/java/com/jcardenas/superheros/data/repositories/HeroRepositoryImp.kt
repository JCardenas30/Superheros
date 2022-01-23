package com.jcardenas.superheros.data.repositories

import androidx.lifecycle.LiveData
import com.jcardenas.superheros.domain.entities.Hero
import com.jcardenas.superheros.domain.repositories.HeroRepository
import kotlinx.coroutines.flow.Flow
import com.jcardenas.superheros.domain.common.Result

class HeroRepositoryImp(
    private val localDataSource: HeroLocalDataSource,
    private val remoteDataSource: HeroRemoteDataSource
): HeroRepository {
    override fun getRemoteHero(id: Int, response: (result: Result<Hero>) -> Unit){
        return remoteDataSource.getHero(id, response)
    }

    override suspend fun getHeroById(id: Int): Flow<Hero> {
        return localDataSource.getHero(id)
    }

    override suspend fun insert(heros: List<Hero>) {
        localDataSource.insert(heros)
    }
}