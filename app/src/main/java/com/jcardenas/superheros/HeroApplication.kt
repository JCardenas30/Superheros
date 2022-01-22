package com.jcardenas.superheros

import android.app.Application
import com.jcardenas.superheros.data.repositories.HeroRepositoryImp
import com.jcardenas.superheros.domain.usecases.GetLocalHeroUseCase
import com.jcardenas.superheros.domain.usecases.GetRemoteHeroUseCase
import com.jcardenas.superheros.helpers.ServiceLocator

class HeroApplication: Application() {
    private val heroRepository: HeroRepositoryImp
        get() = ServiceLocator.provideHeroRepository(this)

    val getRemoteHeroUseCase: GetRemoteHeroUseCase
        get() = GetRemoteHeroUseCase(heroRepository)

    val getLocalHeroUseCase: GetLocalHeroUseCase
        get() = GetLocalHeroUseCase(heroRepository)



}