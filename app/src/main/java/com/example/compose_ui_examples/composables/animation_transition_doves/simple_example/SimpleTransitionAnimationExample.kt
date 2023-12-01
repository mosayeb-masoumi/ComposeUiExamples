package com.example.compose_ui_examples.composables.animation_transition_doves.simple_example

import androidx.compose.animation.core.SpringSpec
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.compose_ui_examples.composables.animation_transition_doves.mountains
import com.skydoves.orbital.Orbital
import com.skydoves.orbital.animateSharedElementTransition
import com.skydoves.orbital.rememberContentWithOrbitalScope

@Composable
fun SimpleTransitionAnimationExample() {

    val mountain by remember { mutableStateOf(mountains.first()) }
    var isTransformed by rememberSaveable { mutableStateOf(false) }

    val sharedImage = rememberContentWithOrbitalScope {
        AsyncImage(
            modifier = if (isTransformed) {
                Modifier
                    .fillMaxWidth()
                    .height(500.dp)
            } else {
                Modifier
                    .size(130.dp, 220.dp)
                    .clip(RoundedCornerShape(size = 10.dp))
            }.animateSharedElementTransition(
                orbitalScope = this,
                movementSpec = SpringSpec(stiffness = 500f),
                transformSpec = SpringSpec(stiffness = 500f)
            ),
            model = ImageRequest.Builder(LocalContext.current)
                .data(mountain.image)
                .crossfade(true)
                .build(),
            contentDescription = "Mountain Image",
            contentScale = ContentScale.Crop
        )
    }

    Orbital(
        modifier = Modifier.clickable {
            isTransformed = !isTransformed
        }
    ) {
        if(isTransformed){
            DetailScreen(
                mountain = mountain,
                sharedElement = { sharedImage() }
            )
        }else {
            Column(
                modifier = Modifier.fillMaxSize().padding(20.dp),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom
            ) {
                sharedImage()
            }
        }
    }
}