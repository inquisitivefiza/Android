package com.example.codelab.movie.character.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.codelab.movie.character.presentation.state.CharacterState


@Composable
fun CharacterScreen(modifier: Modifier, charactersState: CharacterState) {
    if (charactersState.isLoading) {
        Box(modifier = modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = modifier.align(Alignment.Center))
        }
    } else if (!charactersState.errorMsg.isNullOrEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize()  // Fill the entire available space
        ) {
            // Text(
            //       text = charactersState.errorMsg.toString(),  // Fallback if errorMsg is null
            //     modifier = Modifier.align(Alignment.Center)  // Center the text within the Box
            //)
            //}


        }
        if (charactersState.characters?.isNotEmpty()!!) {
            LazyColumn {
                items(charactersState.characters) {
                    CharacterItem(modifier = modifier, character = it)

                }

            }
        }
    }
}




