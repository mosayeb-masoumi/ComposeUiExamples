package com.example.compose_ui_examples.composables.drawer_bottombar_material3

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compose_ui_examples.composables.drawer_bottombar_material3.screens.ChatDrawerBottomBarScreen
import com.example.compose_ui_examples.composables.drawer_bottombar_material3.screens.HomeDrawerBottomBarScreen
import com.example.compose_ui_examples.composables.drawer_bottombar_material3.screens.MessageDrawerBottomBarScreen

sealed class DrawerBottomBarDestination(val route: String){

    object HomeDrawerBottomBarScreen : DrawerBottomBarDestination("HomeDrawerBottomBarScreen")
    object MessageDrawerBottomBarScreen : DrawerBottomBarDestination("MessageDrawerBottomBarScreen")
    object ChatDrawerBottomBarScreen : DrawerBottomBarDestination("ChatDrawerBottomBarScreen")
}


@Composable
fun NavigationAppHostDrawerBottomBar(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = DrawerBottomBarDestination.HomeDrawerBottomBarScreen.route
    ) {

        composable(DrawerBottomBarDestination.HomeDrawerBottomBarScreen.route) {HomeDrawerBottomBarScreen(navController) }
        composable(DrawerBottomBarDestination.MessageDrawerBottomBarScreen.route) { MessageDrawerBottomBarScreen(navController) }
        composable(DrawerBottomBarDestination.ChatDrawerBottomBarScreen.route) { ChatDrawerBottomBarScreen(navController) }

    }
}
