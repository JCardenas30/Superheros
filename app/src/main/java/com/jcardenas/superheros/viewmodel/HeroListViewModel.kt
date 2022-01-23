package com.jcardenas.superheros.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jcardenas.superheros.domain.common.Result
import com.jcardenas.superheros.domain.entities.Hero
import com.jcardenas.superheros.domain.usecases.GetLocalHeroUseCase
import com.jcardenas.superheros.domain.usecases.GetRemoteHeroUseCase
import com.jcardenas.superheros.helpers.Constants
import kotlinx.coroutines.launch

class HeroListViewModel: ViewModel() {
    private lateinit var getLocalHeroUseCase: GetLocalHeroUseCase
    private lateinit var getRemoteHeroUseCase: GetRemoteHeroUseCase

    val isLoading = MutableLiveData(true)
    val remoteHeros = MutableLiveData<MutableList<Hero>>(mutableListOf())

    fun setHeroRemoteUseCase(heroRemoteHeroUseCase: GetRemoteHeroUseCase){
        this.getRemoteHeroUseCase = heroRemoteHeroUseCase
    }

    fun setLocalHeroUseCase(localHeroUseCase: GetLocalHeroUseCase) {
        this.getLocalHeroUseCase = localHeroUseCase
    }

    fun getHeroes(){
        var lastHeroId = if(remoteHeros.value?.isNotEmpty() == true)
            remoteHeros.value?.last()!!.id + 1 else 1

        remoteHeros.value?.clear()
        getRecursiveHeros(lastHeroId)

    }

    fun getRecursiveHeros(heroId: Int = 1, numberOfDownloaded: Int = 0){
        if(heroId >= Constants.MAX_CHARACTER_ID || numberOfDownloaded >= Constants.HEROS_TO_GET) {
            //finish
            remoteHeros.value = remoteHeros.value
            insertHeroes()
            isLoading.value = false
            return
        }

        if (isLoading.value != true)
            isLoading.value = true

        Log.i("obteniendo hero: ", "$heroId")
        getRemoteHeroUseCase.invoke(heroId) { resultHero ->
            when(resultHero){
                is Result.Success -> {
                    remoteHeros.value?.add(resultHero.data)
                }
                is Result.Error -> {}
            }
            getRecursiveHeros(heroId + 1, numberOfDownloaded + 1)
        }
    }

    fun insertHeroes(){
        viewModelScope.launch {
            getLocalHeroUseCase.insert(remoteHeros.value ?: emptyList())
        }
    }
}