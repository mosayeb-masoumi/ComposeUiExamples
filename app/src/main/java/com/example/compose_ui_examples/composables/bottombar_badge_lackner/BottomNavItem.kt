package com.example.compose_ui_examples.composables.bottombar_badge_lackner

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val name:String,
    val route:String ,
    val icon: ImageVector,
    val badgeCount: Int
)
