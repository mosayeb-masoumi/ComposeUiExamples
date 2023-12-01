package com.example.compose_ui_examples.composables.shimmer_effect

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedShimmer() {

    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f)
    )

    val transition = rememberInfiniteTransition()
    val translateAnim = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,  // 1 second
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing,
            )
        )
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = translateAnim.value, y = translateAnim.value)
    )

    ShimmerItem(brush = brush)
}

@Composable
fun ShimmerItem(brush: Brush) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 10.dp), verticalAlignment = Alignment.CenterVertically
    ) {

        Spacer(
            modifier = Modifier
                .size(80.dp)
                .clip(shape = CircleShape)
                .background(brush)
        )
        Spacer(modifier = Modifier.width(10.dp))

        Column(verticalArrangement = Arrangement.Center) {

            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .fillMaxWidth(fraction = 0.7f)
                    .clip(RoundedCornerShape(10.dp))
                    .background(brush)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Spacer(modifier = Modifier
                .height(20.dp)
                .fillMaxWidth(fraction = 0.9f)
                .clip(RoundedCornerShape(10.dp))
                .background(brush))
        }
    }
}


@Composable
@Preview(showBackground = true)
fun ShimmerItemPreview(){
    ShimmerItem(brush = Brush.linearGradient(
        listOf(
            Color.LightGray.copy(alpha = 0.6f),
            Color.LightGray.copy(alpha = 0.2f),
            Color.LightGray.copy(alpha = 0.6f)
        )
    ))
}


@Composable
@Preview(showBackground = true , uiMode = UI_MODE_NIGHT_YES)
fun ShimmerItemDarkPreview(){
    ShimmerItem(brush = Brush.linearGradient(
        listOf(
            Color.LightGray.copy(alpha = 0.6f),
            Color.LightGray.copy(alpha = 0.2f),
            Color.LightGray.copy(alpha = 0.6f)
        )
    ))
}