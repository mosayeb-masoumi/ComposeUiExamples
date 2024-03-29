package com.example.compose_ui_examples.composables.bottombar_badge_lackner.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun HomeBottomBarBadgeScreen (){

    Column(
        modifier = Modifier.fillMaxSize().background(color = Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {

        Text(text = "Home Screen" , color = Color.White, fontSize = 20.sp , fontWeight = FontWeight.Bold)
    }
}