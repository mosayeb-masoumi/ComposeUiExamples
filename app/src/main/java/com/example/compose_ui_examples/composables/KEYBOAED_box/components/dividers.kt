package com.example.compose_ui_examples.composables.KEYBOAED_box.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun BottomFadeDivider() {
    Divider(
        modifier = Modifier
            .fillMaxHeight()
            .width(1.dp)
            .padding(bottom = 10.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.Gray,
                        Color.Gray.copy(alpha = 0.5f),
                        Color.Gray.copy(alpha = 0.3f),
                        Color.Gray.copy(alpha = 0.1f),
                    )
                )

            )
    )
}


@Composable
fun TopFadeDivider() {
    Divider(
        modifier = Modifier
            .fillMaxHeight()
            .width(1.dp)
            .padding(top = 10.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.Gray.copy(alpha = 0.1f),
                        Color.Gray.copy(alpha = 0.3f),
                        Color.Gray.copy(alpha = 0.5f),
                        Color.Gray,
                    )
                )

            )
    )
}

@Composable
fun MiddleDivider() {
    Divider(
        modifier = Modifier
            .fillMaxHeight()
            .width(1.dp)
            .background(color = Color.Gray)
    )
}

@Composable
fun HorizontalDivider() {

    Divider(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(

                        Color.Gray.copy(alpha = 0.1f),
                        Color.Gray.copy(alpha = 0.3f),
                        Color.Gray.copy(alpha = 0.5f),
                        Color.Gray,
                        Color.Gray.copy(alpha = 0.5f),
                        Color.Gray.copy(alpha = 0.3f),
                        Color.Gray.copy(alpha = 0.1f),

                        )
                )

            )
    )


}