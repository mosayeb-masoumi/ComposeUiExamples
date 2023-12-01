@file:OptIn(ExperimentalAnimationApi::class)

package com.example.compose_ui_examples.composables


import androidx.compose.animation.*
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

import com.example.compose_ui_examples.R

@Composable
fun VisibilityGone() {

    val visibleState = remember {
        MutableTransitionState(false).apply {
            targetState = true // start the animation immediately
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
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
            text = when {
                visibleState.isIdle && visibleState.currentState -> "Visible" // enter transition is completed
                !visibleState.isIdle && visibleState.currentState -> "Disappearing" // exit transition is running
                visibleState.isIdle && !visibleState.currentState -> "Invisible" // exit transition is completed
                else -> "Appearing" // enter transition is running
            }
        )


        Spacer(modifier = Modifier.height(50.dp))


        // second example
        var isVisible by remember { mutableStateOf(false) }
        Button(onClick = {
            isVisible = !isVisible
        }) {
            Text(text = "Toggle")
        }

        AnimatedVisibility(
            visible = isVisible,
            enter = slideInHorizontally() + fadeIn(),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(modifier = Modifier.background(color = Color.Red))
        }




        var isVisible2 by remember { mutableStateOf(false) }
        Button(onClick = {
            isVisible2 = !isVisible2
        }) {
            Text(text = "Animated Content")
        }

        AnimatedContent(
            targetState = isVisible2, modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            content = { isVisible ->

                if (isVisible) {
                    Box(
                        modifier = Modifier
                            .size(200.dp)
                            .background(Color.Gray),
                        contentAlignment = Alignment.Center
                    ){
                        Text(text = "First content")
                    }
                } else {
                    Box(modifier = Modifier
                        .size(200.dp)
                        .background(Color.Magenta),
                        contentAlignment = Alignment.Center
                    ){
                        Text(text = "Second Content")
                    }
                }
            },

        )

    }
}