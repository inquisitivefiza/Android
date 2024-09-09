package com.example.codelab.movie.character.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.codelab.movie.character.presentation.components.CharacterScreen
import com.example.codelab.movie.character.presentation.viewmodel.CharactersViewModel

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination =Screen.CharacterScreen.route ){


      composable(Screen.CharacterScreen.route) {
          val characterViewModel = hiltViewModel<CharactersViewModel>()
          val characterState = characterViewModel.characterState.collectAsStateWithLifecycle().value

          CharacterScreen(modifier = androidx.compose.ui.Modifier, charactersState = characterState)
      }


      }
    }


