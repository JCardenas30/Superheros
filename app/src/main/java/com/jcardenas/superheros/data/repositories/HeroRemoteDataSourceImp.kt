package com.jcardenas.superheros.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jcardenas.superheros.data.api.HeroApiResponse
import com.jcardenas.superheros.data.api.HeroeApi
import com.jcardenas.superheros.data.mappers.HeroApiResponseMapper
import com.jcardenas.superheros.domain.common.Result
import com.jcardenas.superheros.domain.entities.Hero
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class HeroRemoteDataSourceImp(
    private val service: HeroeApi,
    private val mapper: HeroApiResponseMapper
): HeroRemoteDataSource {

    override fun getHero(heroId: Int, response: (result: Result<Hero>) -> Unit){
        service.getHeroById(heroId).enqueue(object: Callback<HeroApiResponse> {
            override fun onResponse(
                call: Call<HeroApiResponse>,
                response: Response<HeroApiResponse>
            ) {
                if(response.isSuccessful)
                    response(Result.Success(mapper.toHero(response.body()!!)))
                else
                    response(Result.Error(Exception(response.message())))
            }

            override fun onFailure(call: Call<HeroApiResponse>, t: Throwable) {
                response(Result.Error(Exception(t.message)))
            }
        })
    }
}