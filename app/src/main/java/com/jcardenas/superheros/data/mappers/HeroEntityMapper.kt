package com.jcardenas.superheros.data.mappers

import com.jcardenas.superheros.data.entities.HeroEntity
import com.jcardenas.superheros.domain.entities.Hero

class HeroEntityMapper {
    fun toHeroEntity(hero: Hero): HeroEntity {
        return HeroEntity(
            id = hero.id,
            name = hero.name,
            image = hero.image
        )
    }

    fun toHero(heroEntity: HeroEntity): Hero {
        return Hero(
            id = heroEntity.id,
            name = heroEntity.name,
            image = heroEntity.image
        )
    }
}