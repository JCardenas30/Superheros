package com.jcardenas.superheros.data.api

data class HeroApiResponse(
    val response: String,
    val id: Int,
    val name: String,
    val image: String
)