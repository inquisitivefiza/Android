package com.example.codelab.movie.character.di.model

data class Characters(
    val actor: String,
    val id: String,
    val image: String,
    val name: String,

) {
    fun toDomainCharacter() {
        TODO("Not yet implemented")
    }
}