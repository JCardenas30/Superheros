package com.jcardenas.superheros.data.repositories

import com.jcardenas.superheros.data.db.HeroDao
import com.jcardenas.superheros.data.entities.HeroEntity
import com.jcardenas.superheros.data.mappers.HeroEntityMapper
import com.jcardenas.superheros.domain.entities.Hero
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class HeroLocalDataSourceImp(
    private val heroDao: HeroDao,
    private val dispatcher: CoroutineDispatcher,
    private val heroEntityMapper: HeroEntityMapper
): HeroLocalDataSource {
    override suspend fun insert(heros: List<Hero>) = withContext(dispatcher) {
        val tmp = mutableListOf<HeroEntity>()
        heros.forEach { hero ->
            tmp.add(heroEntityMapper.toHeroEntity(hero))
        }
        heroDao.insertHeros(tmp)
    }

    override suspend fun getHero(heroId: Int): Flow<Hero> {
        val savedHeroFlow = heroDao.getHero(heroId)
        return savedHeroFlow.map { heroEntity ->
            heroEntityMapper.toHero(heroEntity)
        }
    }
}