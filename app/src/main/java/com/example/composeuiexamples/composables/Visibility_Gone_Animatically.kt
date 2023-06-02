package com.example.composeuiexamples.composables

import androidx.compose.animation.*
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

import com.example.composeuiexamples.R

@Composable
fun VisibilityGone() {

    val visibleState = remember {
        MutableTransitionState(false).apply {
            targetState = true // start the animation immediately
        }
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        AnimatedVisibility(
            visibleState = visibleState,
            enter = fadeIn() + slideInHorizontally(),
            exit = fadeOut() + slideOutHorizontally()
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_cleaning),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(shape = CircleShape)
            )
        }


        Button(onClick = {
            visibleState.targetState = !visibleState.targetState
        }) {

            Text(text = "toggle visibility")
        }

        Text(
            text = when{
                visibleState.isIdle && visibleState.currentState -> "Visible" // enter transition is completed
                !visibleState.isIdle && visibleState.currentState -> "Disappearing" // exit transition is running
                visibleState.isIdle && !visibleState.currentState -> "Invisible" // exit transition is completed
                else -> "Appearing" // enter transition is running
            })

    }
}