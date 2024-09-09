package com.example.codelab.movie.character.data.mapper

import com.example.codelab.movie.character.data.dto.CharactersDto
import com.example.codelab.movie.character.di.model.Characters

fun CharactersDto.toDomainCharacter(): Characters {
    return Characters(actor,id,image,name)
}