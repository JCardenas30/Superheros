package com.jcardenas.superheros.domain.entities

import com.jcardenas.superheros.helpers.ListItemViewModel

class Hero(
    val id: Int,
    val name: String,
    val image: String,
    val intelligence: String,
    val strength: String,
    val speed: String,
    val durability: String,
    val power: String,
    val combat: String,
    val fullName: String,
    val alterEgos: String,
    val aliases: String,
    val placeOfBirth: String,
    val firstAppearance: String,
    val publisher: String,
    val alignment: String,
    val gender: String,
    val race: String,
    val height: String,
    val weight: String,
    val eyeColor: String,
    val hairColor: String,
    val occupation: String,
    val base: String,
    val groupAffiliation: String,
    val relatives: String
): ListItemViewModel()