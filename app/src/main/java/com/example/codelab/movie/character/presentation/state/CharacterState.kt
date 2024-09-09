package com.example.codelab.movie.character.presentation.state

import com.example.codelab.movie.character.di.model.Characters

data class CharacterState(
    val characters:List<Characters> ?= emptyList(),
    val errorMsg:String?="",
    val isLoading:Boolean =false
)
