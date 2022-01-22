package com.jcardenas.superheros.viewmodel

import androidx.lifecycle.ViewModel
import com.jcardenas.superheros.domain.usecases.GetRemoteHeroUseCase

class HeroDetailViewModel: ViewModel() {

    private lateinit var getHeroRemoteUseCase: GetRemoteHeroUseCase

    fun setHeroRemoteUseCase(heroRemoteHeroUseCase: GetRemoteHeroUseCase){
        this.getHeroRemoteUseCase = heroRemoteHeroUseCase
    }


}