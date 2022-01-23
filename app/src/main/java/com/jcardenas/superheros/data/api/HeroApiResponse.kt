package com.jcardenas.superheros.data.api

import com.squareup.moshi.Json

data class HeroApiResponseTest(
    val response: String
)

data class HeroApiResponse(
    @field:Json(name = "response")
    val response: String,

    @field:Json(name = "id")
    val id: Int,

    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "powerstats")
    val powerstats: PowerstatsApiResponse,

    @field:Json(name = "biography")
    val biography: BiographyApiResponse,

    @field:Json(name = "appearance")
    val appearance: AppearanceApiResponse,

    @field:Json(name = "work")
    val work: WorkApiResponse,

    @field:Json(name = "connections")
    val connections: ConnectionsApiResponse,

    @field:Json(name = "image")
    val image: ImageApiResponse
)

data class PowerstatsApiResponse(
    val intelligence: String,
    val strength: String,
    val speed: String,
    val durability: String,
    val power: String,
    val combat: String
)

data class BiographyApiResponse(
    @Json(name = "full-name") val fullName: String,
    @Json(name = "alter-egos") val alterEgos: String,
    val aliases: List<String>,
    @Json(name = "place-of-birth") val placeOfBirth: String,
    @Json(name = "first-appearance") val firstAppearance: String,
    val publisher: String,
    val alignment: String
)

data class AppearanceApiResponse(
    val gender: String,
    val race: String,
    val height: List<String>,
    val weight: List<String>,
    @Json(name = "eye-color") val eyeColor: String,
    @Json(name = "hair-color") val hairColor: String
)

data class WorkApiResponse(
    val occupation: String,
    val base: String
)

data class ConnectionsApiResponse(
    @Json(name = "group-affiliation") val groupAffiliation: String,
    val relatives: String
)

data class ImageApiResponse(
    val url: String
)