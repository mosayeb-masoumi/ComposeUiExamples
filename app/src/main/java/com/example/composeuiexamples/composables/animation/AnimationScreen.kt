package com.example.composeuiexamples.composables.animation

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimationScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        AnimationExample1()
        AnimationExample2()


    }
}

@Composable
fun AnimationExample1() {

    var sizeState by remember { mutableStateOf(200.dp) }
    val size by animateDpAsState(
        targetValue = sizeState,

        // 1
        tween(
            durationMillis = 3000,
            delayMillis = 300,
            easing = LinearOutSlowInEasing
        )

        //2
//        spring(
//          Spring.DampingRatioHighBouncy
//        )
    )


    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Green,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 2000),
            repeatMode = RepeatMode.Reverse
        )
    )
    Box(
        modifier = Modifier
            .size(size)
            .background(color),
        contentAlignment = Alignment.Center
    ) {

        Button(onClick = {
            sizeState += 50.dp
        }) {
            Text(text = "increase size")
        }
    }
}

@Composable
fun AnimationExample2() {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // second example
        var isVisible by remember { mutableStateOf(false) }
        var isRound by remember { mutableStateOf(false) }


        Button(onClick = {
            isVisible = !isVisible
            isRound = !isRound
        }) {
            Text(text = "Toggle")
        }

        val borderRadius by animateIntAsState(
            targetValue = if (isRound) 100 else 0,
            animationSpec = tween(
                durationMillis = 2000,
                delayMillis = 300
            )
        )

        val transition = rememberInfiniteTransition()
        val color by transition.animateColor(
            initialValue = Color.Blue,
            targetValue = Color.Yellow ,
            animationSpec = infiniteRepeatable(
                animation = tween(2000),
                repeatMode = RepeatMode.Reverse
            )
        )

        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(borderRadius))
                .background(color)
        )

    }
}