package com.jcardenas.superheros.domain.usecases

import com.jcardenas.superheros.domain.repositories.HeroRepository

class GetRemoteHeroUseCase(private val heroRepository: HeroRepository) {
    suspend operator fun invoke(heroId: Int) = heroRepository.getRemoteHero(heroId)
}

class GetLocalHeroUseCase(private val heroRepository: HeroRepository) {
    fun invoke(heroId: Int) = heroRepository.getHeroById(heroId)
}