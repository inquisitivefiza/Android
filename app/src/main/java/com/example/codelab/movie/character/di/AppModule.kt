package com.example.codelab.movie.character.di

import CharactersRepositoryImpl
import com.example.codelab.movie.character.core.util.Constants.BASE_URL
import com.example.codelab.movie.character.data.api.CharacterApi
import com.example.codelab.movie.character.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent ::class)

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideRetrofitInstance()= Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())

        .baseUrl(BASE_URL)
        .build()
    @Provides
    @Singleton
    fun  provideCharactersApi(retrofit :Retrofit): CharacterApi = retrofit.create(CharacterApi :: class.java)
    @Provides
    @Singleton
    fun provideCharacterRepository(api: CharacterApi) :CharacterRepository{
        return  CharactersRepositoryImpl(api)
    }

}