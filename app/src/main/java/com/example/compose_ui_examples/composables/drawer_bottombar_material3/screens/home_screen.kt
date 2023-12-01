package com.example.compose_ui_examples.composables.drawer_bottombar_material3.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun HomeDrawerBottomBarScreen(navController: NavHostController) {
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green.copy(alpha = 0.5f)),
        contentAlignment = Alignment.Center
    ) {
        
        Text(text = "Home Screen", fontSize = 25.sp, color = Color.White , fontWeight = FontWeight.Bold)
    }
}
