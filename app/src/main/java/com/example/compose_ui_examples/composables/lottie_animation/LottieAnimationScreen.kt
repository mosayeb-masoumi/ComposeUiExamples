package com.example.compose_ui_examples.composables.lottie_animation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.compose_ui_examples.R

@Composable
fun LottieAnimationScreen() {

    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.welcome))
    var isPlaying by remember { mutableStateOf(true) }

    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = isPlaying
    )
    
    LaunchedEffect(key1 = progress){
        if(progress == 0f){
          isPlaying = true
        }
        if(progress == 1f){
           isPlaying = false
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        LottieAnimation(
            modifier = Modifier.size(300.dp),
            composition = composition,
            progress = {progress}
        )

        Button(onClick = {
           isPlaying = true
        }) {
            Text(text = "Play again")
        }
    }
}