package com.jcardenas.superheros.model

import com.jcardenas.superheros.helpers.ListItemViewModel

data class Hero(
    val id: Int,
    val name: String,
    val image: String
): ListItemViewModel()