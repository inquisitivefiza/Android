package com.example.codelab.movie.character.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codelab.movie.character.core.common.Resource
import com.example.codelab.movie.character.domain.usecase.GetAllCharacterUseCase
import com.example.codelab.movie.character.presentation.state.CharacterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@HiltViewModel
class CharactersViewModel @Inject constructor(private val usecase :GetAllCharacterUseCase) : ViewModel() {
     private  val  _charactersState= MutableStateFlow(CharacterState())
    val characterState: StateFlow<CharacterState>
        get() =_charactersState

    init {
        getAllCharacters()

    }
    private fun getAllCharacters(){
        usecase().onEach{
            when(it)  {
                is Resource.Error -> {
                    _charactersState.value = CharacterState().copy(errorMsg =it.msg )
                }
                is Resource.Loading -> {
                    _charactersState.value = CharacterState().copy(isLoading = true )
                }
                is Resource.Success -> {
                    _charactersState.value = CharacterState().copy(characters =it.data )
                }
            }

        }.launchIn(viewModelScope)
    }

}