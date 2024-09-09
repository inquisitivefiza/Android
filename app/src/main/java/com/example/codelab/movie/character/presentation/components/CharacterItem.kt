package com.example.codelab.movie.character.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.codelab.movie.character.di.model.Characters


@Composable
fun CharacterItem(
    modifier: Modifier = Modifier,  // Ensure a default value for modifier
    character: Characters
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Card(
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                modifier = Modifier  // Use a fresh modifier for the internal components
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // AsyncImage component for character image
                AsyncImage(
                    model = character.image,
                    contentDescription = "Character Image",  // Proper content description
                    modifier = Modifier  // Fresh modifier for AsyncImage
                        .padding(16.dp)
                        .fillMaxWidth()
                        .clip(RectangleShape),
                    contentScale = ContentScale.Crop
                )


               // Text(
                   // text = character.actor,
                 //   style = MaterialTheme.typography.headlineMedium,  // Use typography
                   // modifier = Modifier.padding(top = 8.dp)
               // )

                // Text for character name with typography
                //Text(
                 // text = character.name,
                   //style = MaterialTheme.typography.bodyLarge,  // Use typography
                  //  modifier = Modifier.padding(top = 4.dp)
             // )


               Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}




