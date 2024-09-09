package com.example.codelab.movie.character.data.api

import com.example.codelab.movie.character.di.model.Characters
import retrofit2.http.GET

interface CharacterApi {
    @GET("characters")
    suspend fun getAllCharacters():List<Characters>
}