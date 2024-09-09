package com.example.codelab.movie.character.presentation.state

data class CharacterState(
    val characters: List<Unit>? = emptyList(),
    val errorMsg:String?="",
    val isLoading:Boolean =false
)
