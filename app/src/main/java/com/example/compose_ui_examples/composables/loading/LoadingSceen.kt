package com.example.compose_ui_examples.composables.loading

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.compose_ui_examples.composables.lottie_animation.RunningManLottie

@Composable
fun LoadingScreen() {


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
//        LoadingDialog()
//        LoadingAnimation1()
//        LoadingGradient()
//        LoadingDots()
//        LoadingRipple()
        RunningManLottie()
    }


}

