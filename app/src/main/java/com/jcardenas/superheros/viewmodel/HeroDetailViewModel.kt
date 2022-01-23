package com.jcardenas.superheros.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jcardenas.superheros.domain.entities.Hero
import com.jcardenas.superheros.domain.usecases.GetLocalHeroUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HeroDetailViewModel: ViewModel() {
    private lateinit var getLocalHeroUseCase: GetLocalHeroUseCase

    fun setLocalHeroUseCase(localHeroUseCase: GetLocalHeroUseCase) {
        this.getLocalHeroUseCase = localHeroUseCase
    }

    val heroLiveData = MutableLiveData<Hero>()
    val heroId = MutableLiveData<Int>()

    fun getHeroById(){
        viewModelScope.launch {
            getLocalHeroUseCase.invoke(heroId.value ?: 0).collect { hero ->
                heroLiveData.value = hero
            }
        }
    }
}