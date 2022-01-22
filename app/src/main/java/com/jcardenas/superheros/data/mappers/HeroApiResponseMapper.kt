package com.jcardenas.superheros.data.mappers

import com.jcardenas.superheros.data.api.HeroApiResponse
import com.jcardenas.superheros.domain.entities.Hero

class HeroApiResponseMapper {

    fun toHero(response: HeroApiResponse): Hero {
        return Hero(
            id = response.id,
            name = response.name,
            image = response.image
        )
    }
}