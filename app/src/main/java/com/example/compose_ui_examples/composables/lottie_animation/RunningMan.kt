package com.example.compose_ui_examples.composables.lottie_animation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.compose_ui_examples.R

@Composable
fun RunningManLottie(){

    // https://semicolonspace.com/jetpack-compose-lottie-animations/

    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(resId = R.raw.running_man_lottie)
    )

    // render the animation
    LottieAnimation(
        modifier = Modifier.size(size = 240.dp),
        composition = composition,
        iterations = LottieConstants.IterateForever, // animate forever
//        clipSpec = LottieClipSpec.Progress(0.5f, 0.75f)  trim/cut (leyley)
        speed = 2f // double speed (default is 1f)
    )

//    Spacer(modifier = Modifier.height(height = 12.dp))

//    Text(
//        text = "Lottie Animation",
//        fontSize = 28.sp
//    )
}