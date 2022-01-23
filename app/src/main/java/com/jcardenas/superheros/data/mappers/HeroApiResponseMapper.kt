package com.jcardenas.superheros.data.mappers

import com.jcardenas.superheros.data.api.HeroApiResponse
import com.jcardenas.superheros.domain.entities.Hero

class HeroApiResponseMapper {

    fun toHero(response: HeroApiResponse): Hero {
        return Hero(
            id = response.id,
            name = response.name,
            image = response.image.url,
            intelligence = response.powerstats.intelligence,
            strength = response.powerstats.strength,
            speed = response.powerstats.speed,
            durability = response.powerstats.durability,
            power = response.powerstats.durability,
            combat = response.powerstats.combat,
            fullName = response.biography.fullName,
            alterEgos = response.biography.alterEgos,
            aliases = response.biography.aliases.joinToString(", "),
            placeOfBirth = response.biography.placeOfBirth,
            firstAppearance = response.biography.firstAppearance,
            publisher = response.biography.publisher,
            alignment = response.biography.alignment,
            gender = response.appearance.gender,
            race = response.appearance.race,
            height = response.appearance.height.joinToString(" (") + ")",
            weight = response.appearance.weight.joinToString(" (") + ")",
            eyeColor = response.appearance.eyeColor,
            hairColor = response.appearance.hairColor,
            occupation = response.work.occupation,
            base = response.work.base,
            groupAffiliation = response.connections.groupAffiliation,
            relatives = response.connections.relatives
        )
    }
}