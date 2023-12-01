package com.example.compose_ui_examples.composables.pinch_zoom_rotate_image

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import com.example.compose_ui_examples.R

import androidx.compose.ui.tooling.preview.Preview

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun ZoomRotateImageScreen() {


    // sourec https://www.youtube.com/watch?v=3CjOyoqi_PQ&t=2s

    var scale by remember { mutableStateOf(1f) }
    var rotation by remember { mutableStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }


    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Blue.copy(alpha = 0.5f)),
        contentAlignment = Alignment.Center
    ) {

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(4128f / 2322)  // check the scale of image and put here
        ) {

            val state = rememberTransformableState { zoomChange, panChange, rotationChange ->
                scale = (scale * zoomChange).coerceIn(1f, 5f)  // 5f is value of maxZoom

                rotation += rotationChange

                // these 2 below lines are for preventing hollow bound when image moved to the end of each side
                val extraWidth = (scale - 1) * constraints.maxWidth
                val extraHeight = (scale - 1) * constraints.maxHeight

                val maxX = extraWidth / 2
                val maxY = extraHeight / 2
                offset = Offset(
                    x = (offset.x + scale * panChange.x).coerceIn(-maxX , maxX),
                    y = (offset.y + scale * panChange.y).coerceIn(-maxY , maxY),
                )

//                offset += panChange  // this line is to be able to move the image whith bound when it's zoomed
            }
            Image(
                painter = painterResource(id = R.drawable.bahar),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .graphicsLayer {
                        scaleX = scale
                        scaleY = scale
                        rotationZ = rotation
                        translationX = offset.x
                        translationY = offset.y
                    }
                    .transformable(state)
            )
        }

    }


}


@Preview
@Composable
fun ZoomRotateImageScreenPreview() {
    ZoomRotateImageScreen()
}