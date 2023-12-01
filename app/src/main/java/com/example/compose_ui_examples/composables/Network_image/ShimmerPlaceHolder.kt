package com.example.compose_ui_examples.composables.Network_image

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerPlaceHolder(width:Int ,height: Int){

    val transition = rememberInfiniteTransition()
    val colorShimmer = transition.animateColor(
        initialValue = Color.LightGray,
        targetValue = Color.DarkGray,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = Modifier
            .height(height = height.dp)
            .width(width.dp)
//            .clip(RoundedCornerShape(20.dp))
            .clip(shape = CircleShape)
            .background(color = colorShimmer.value)
    )

}