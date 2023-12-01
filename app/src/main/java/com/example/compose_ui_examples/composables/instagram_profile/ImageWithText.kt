package com.example.compose_ui_examples.composables.instagram_profile

import androidx.compose.ui.graphics.painter.Painter

data class ImageWithText(
    val image: Painter,
    val text: String
)