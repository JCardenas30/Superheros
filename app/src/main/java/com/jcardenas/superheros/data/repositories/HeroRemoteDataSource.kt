package com.jcardenas.superheros.data.repositories

import androidx.lifecycle.LiveData
import com.jcardenas.superheros.domain.common.Result
import com.jcardenas.superheros.domain.entities.Hero

interface HeroRemoteDataSource {

    fun getHero(heroId: Int, response: (result: Result<Hero>) -> Unit)
}