package com.example.compose_ui_examples.composables.glassmorphism

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_ui_examples.R

@Composable
fun GlassMorphismScreen() {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.philipp), contentDescription = "",
            contentScale = ContentScale.Crop
        )


        Box(
            modifier =
            Modifier
                .size(250.dp)
                .clip(shape = RoundedCornerShape(30.dp))
                .border(width = 2.dp, color = Color.Red, shape = RoundedCornerShape(30.dp))
                .background(color = Color.White.copy(alpha = 0.5f))


        ) {

        }

    }
}


@Preview
@Composable
fun GlassMorphismScreenPreview() {
    GlassMorphismScreen()
}