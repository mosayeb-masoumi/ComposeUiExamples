package com.example.compose_ui_examples.composables.shimmer_effect

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedShimmerScreen() {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(all = 10.dp)) {

        repeat(10){
            AnimatedShimmer()
        }
    }
}

@Preview
@Composable
fun AnimatedShimmerScreenPreview(){
    AnimatedShimmerScreen()
}