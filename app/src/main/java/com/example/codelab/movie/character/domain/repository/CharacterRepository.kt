package com.example.codelab.movie.character.domain.repository

import com.example.codelab.movie.character.core.common.Resource
import com.example.codelab.movie.character.di.model.Characters
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

     fun getAllCharacters() : Flow<Resource<List<Unit>>>

}