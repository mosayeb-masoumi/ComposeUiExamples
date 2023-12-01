package com.example.compose_ui_examples.composables.countdown_animated

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CountDownAnimated() {

    // source = https://stackoverflow.com/questions/77529128/android-jetpack-compose-countdown-animation/77531053#77531053

    var timer by remember { mutableStateOf(5) }

    val coroutineScope = rememberCoroutineScope()

    val animatedCountDownTimer = remember {
        AnimatedCountdownTimer(coroutineScope)
    }

    if(timer == 0){
       // do something
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            modifier = Modifier.graphicsLayer {
                scaleX = animatedCountDownTimer.scale
                scaleY = animatedCountDownTimer.scale
                alpha = animatedCountDownTimer.alpha
            },
            text = "$timer",
            fontSize = 120.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(20.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                animatedCountDownTimer.start(5, 0) {
                    timer = it
                }
            }) {
            Text(text = "Start")
        }
    }
}