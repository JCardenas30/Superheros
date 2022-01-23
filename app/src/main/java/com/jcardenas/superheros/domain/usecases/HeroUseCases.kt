package com.jcardenas.superheros.domain.usecases

import com.jcardenas.superheros.domain.common.Result
import com.jcardenas.superheros.domain.entities.Hero
import com.jcardenas.superheros.domain.repositories.HeroRepository

class GetRemoteHeroUseCase(private val heroRepository: HeroRepository) {
    fun invoke(heroId: Int, response: (result: Result<Hero>) -> Unit) = heroRepository.getRemoteHero(heroId, response)
}

class GetLocalHeroUseCase(private val heroRepository: HeroRepository) {
    suspend fun invoke(heroId: Int) = heroRepository.getHeroById(heroId)
    suspend fun insert(heroes: List<Hero>) = heroRepository.insert(heroes)
}