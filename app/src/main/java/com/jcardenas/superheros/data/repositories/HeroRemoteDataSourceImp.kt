package com.jcardenas.superheros.data.repositories

import com.jcardenas.superheros.data.api.HeroeApi
import com.jcardenas.superheros.data.mappers.HeroApiResponseMapper
import com.jcardenas.superheros.domain.common.Result
import com.jcardenas.superheros.domain.entities.Hero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class HeroRemoteDataSourceImp(
    private val service: HeroeApi,
    private val mapper: HeroApiResponseMapper
): HeroRemoteDataSource {

    override suspend fun getHero(heroId: Int): Result<Hero> = withContext(Dispatchers.IO) {
        try {
            val response = service.getHeroById(heroId)
            if(response.isSuccessful)
                 return@withContext Result.Success(mapper.toHero(response.body()!!))
            else
                return@withContext Result.Error(Exception(response.message()))
        }catch (e: Exception){
            return@withContext Result.Error(e)
        }
    }
}