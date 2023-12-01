package com.example.compose_ui_examples.composables.animation

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@Composable
fun AnimationScreen() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        item {
            AnimationExample1()
        }
        item {
            AnimationExample2()
        }
        item {
            AnimateVisibilityExample()
        }
        item {
            ExpandingTextExample()
        }

        item {
            AnimatedContainerCompose()
        }

        item {
            AnimatedIconToText()
        }

        item {
            AnimateContentSize()
        }

        item {
            LinearProgressUpdate()
        }

    }

}

@Composable
fun LinearProgressUpdate() {

    var questionIndex by remember { mutableStateOf(0) }
    val totalQuestionIndex by remember { mutableStateOf(6) }

    val progress by animateFloatAsState(
        targetValue = (questionIndex + 1) /totalQuestionIndex.toFloat()
    )

    Column() {
        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier.padding(all = 15.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = {
                questionIndex ++
            }) {
                Text(text = "increase progress ++")
            }

            Button(onClick = {
                questionIndex --
            }) {
                Text(text = "decrease progress --")
            }
        }

    }


}


@Composable
fun AnimateContentSize(
){
    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .padding(all = 10.dp)
            .background(if (expanded) Color.Blue.copy(alpha = 0.5f) else Color.Green.copy(alpha = 0.5f))
            .animateContentSize()
            .height(if (expanded) 400.dp else 200.dp)
            .fillMaxWidth()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                expanded = !expanded
            }

    ) {
    }
}

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialApi::class)
@Composable
fun AnimatedIconToText() {
    var expanded by remember { mutableStateOf(false) }
    Surface(
        color = Color.Transparent,
        onClick = { expanded = !expanded }
    ) {
        AnimatedContent(
            targetState = expanded,
            transitionSpec = {
                fadeIn(animationSpec = tween(150, 150)) with
                        fadeOut(animationSpec = tween(150)) using
                        SizeTransform { initialSize, targetSize ->
                            if (targetState) {
                                keyframes {
                                    // Expand horizontally first.
                                    IntSize(targetSize.width, initialSize.height) at 150
                                    durationMillis = 300
                                }
                            } else {
                                keyframes {
                                    // Shrink vertically first.
                                    IntSize(initialSize.width, targetSize.height) at 150
                                    durationMillis = 300
                                }
                            }
                        }
            }
        ) { targetExpanded ->
            if (targetExpanded) {
                val description = "this is a text this is a text this is a text " +
                        "this is a text this is a text this is a text this is a text this is a text this is a text " +
                        "this is a text this is a text this is a text this is a text this is a text this is a text " +
                        "this is a text this is a text this is a text this is a text this is a text this is a text " +
                        "this is a text this is a text this is a text this is a text this is a text this is a text " +
                        "this is a text this is a text this is a text this is a text this is a text this is a text " +
                        "this is a text this is a text this is a text"

                Text(text = description)
//                Expanded()
//                Box(modifier = Modifier
//                    .size(200.dp)
//                    .background(color = Color.Blue)) {
//                }
            } else {

                Box(modifier = Modifier.fillMaxWidth()) {
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                            .background(color = Color.Green),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(imageVector = Icons.Filled.Phone, contentDescription ="" )
                    }
                }

//                ContentIcon()
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedContainerCompose() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 10.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(color = Color.Green.copy(alpha = 0.2f)),
        contentAlignment = Alignment.Center
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            var count by remember { mutableStateOf(0) }
            Button(onClick = { count++ }) {
                Text(text = "Add ++")
            }
            Spacer(modifier = Modifier.width(10.dp))
            AnimatedContent(
                targetState = count,
                transitionSpec = {
                    // Compare the incoming number with the previous number.
                    if (targetState > initialState) {
                        // If the target number is larger, it slides up and fades in
                        // while the initial (smaller) number slides up and fades out.
                        slideInVertically { height -> height } + fadeIn() with
                                slideOutVertically { height -> -height } + fadeOut()
                    } else {
                        // If the target number is smaller, it slides down and fades in
                        // while the initial number slides down and fades out.
                        slideInVertically { height -> -height } + fadeIn() with
                                slideOutVertically { height -> height } + fadeOut()
                    }.using(
                        // Disable clipping since the faded slide-in/out should
                        // be displayed out of bounds.
                        SizeTransform(clip = false)
                    )
                }
            ) { targetCount ->
                Text(
                    text = "Count: $targetCount",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

    }

}


@Composable
fun ExpandingTextExample() {
    val description = "this is a text this is a text this is a text " +
            "this is a text this is a text this is a text this is a text this is a text this is a text " +
            "this is a text this is a text this is a text this is a text this is a text this is a text " +
            "this is a text this is a text this is a text this is a text this is a text this is a text " +
            "this is a text this is a text this is a text this is a text this is a text this is a text " +
            "this is a text this is a text this is a text this is a text this is a text this is a text " +
            "this is a text this is a text this is a text"

    var expanded by remember { mutableStateOf(false) }
    Text(
        text = description,
        modifier = Modifier
//        .animateContentSize()  // simple
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
            .clickable { expanded = !expanded },
        maxLines = if (!expanded) 2 else 6
    )
}

@Composable
fun AnimateVisibilityExample() {

    var isVisible by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 10.dp)
            .background(color = Color.Red)
            .clickable {
                isVisible = !isVisible
            },

        ) {
        Column() {
            Text(
                text = "this is a text",
                modifier = Modifier.padding(10.dp)
            )

            AnimatedVisibility(visible = isVisible) {
                Text(
                    text = "this is a text \n",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }


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
            targetValue = Color.Yellow,
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

@Composable
@Preview
fun AnimationScreenPreview() {
    AnimationScreen()
}