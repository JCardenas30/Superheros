package com.jcardenas.superheros.data.mappers

import com.jcardenas.superheros.data.entities.HeroEntity
import com.jcardenas.superheros.domain.entities.Hero

class HeroEntityMapper {
    fun toHeroEntity(hero: Hero): HeroEntity {
        return HeroEntity(
            id = hero.id,
            name = hero.name,
            image = hero.image,
            intelligence = hero.intelligence,
            strength = hero.strength,
            speed = hero.speed,
            durability = hero.durability,
            power = hero.durability,
            combat = hero.combat,
            fullName = hero.fullName,
            alterEgos = hero.alterEgos,
            aliases = hero.aliases,
            placeOfBirth = hero.placeOfBirth,
            firstAppearance = hero.firstAppearance,
            publisher = hero.publisher,
            alignment = hero.alignment,
            gender = hero.gender,
            race = hero.race,
            height = hero.height,
            weight = hero.weight,
            eyeColor = hero.eyeColor,
            hairColor = hero.hairColor,
            occupation = hero.occupation,
            base = hero.base,
            groupAffiliation = hero.groupAffiliation,
            relatives = hero.relatives
        )
    }

    fun toHero(heroEntity: HeroEntity): Hero {
        return Hero(
            id = heroEntity.id,
            name = heroEntity.name,
            image = heroEntity.image,
            intelligence = heroEntity.intelligence,
            strength = heroEntity.strength,
            speed = heroEntity.speed,
            durability = heroEntity.durability,
            power = heroEntity.durability,
            combat = heroEntity.combat,
            fullName = heroEntity.fullName,
            alterEgos = heroEntity.alterEgos,
            aliases = heroEntity.aliases,
            placeOfBirth = heroEntity.placeOfBirth,
            firstAppearance = heroEntity.firstAppearance,
            publisher = heroEntity.publisher,
            alignment = heroEntity.alignment,
            gender = heroEntity.gender,
            race = heroEntity.race,
            height = heroEntity.height,
            weight = heroEntity.weight,
            eyeColor = heroEntity.eyeColor,
            hairColor = heroEntity.hairColor,
            occupation = heroEntity.occupation,
            base = heroEntity.base,
            groupAffiliation = heroEntity.groupAffiliation,
            relatives = heroEntity.relatives
        )
    }
}