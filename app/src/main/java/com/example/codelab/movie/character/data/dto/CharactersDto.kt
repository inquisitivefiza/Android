package com.example.codelab.movie.character.data.dto

import com.google.gson.annotations.SerializedName

data class CharactersDto(
    val actor: String,
    val alive: Boolean,
    @SerializedName("alternate_actors")
    val alternateActors: List<String>,
    @SerializedName("alternate_actors")
    val alternateNames: List<String>,
    val ancestry: String,
    val dateOfBirth: String,
    val eyeColour: String,
    val gender: String,
    val hairColour: String,
    val hogwartsStaff: Boolean,
    val hogwartsStudent: Boolean,
    val house: String,
    val id: String,
    val image: String,
    val name: String,
    val patronus: String,
    val species: String,
    //val wand: Wand,
    val wizard: Boolean,
    val yearOfBirth: Int
)