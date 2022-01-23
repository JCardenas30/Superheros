package com.jcardenas.superheros.data.api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HeroeApi {
    @GET("{heroId}")
    fun getHeroById(@Path("heroId") heroId: Int): Call<HeroApiResponse>
}