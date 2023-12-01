package com.example.compose_ui_examples.composables.bottombar_badge_lackner.destination

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compose_ui_examples.composables.bottombar_badge_lackner.screens.ChatBottomBarBadgeScreen
import com.example.compose_ui_examples.composables.bottombar_badge_lackner.screens.HomeBottomBarBadgeScreen
import com.example.compose_ui_examples.composables.bottombar_badge_lackner.screens.SettingBottomBarBadgeScreen


sealed class DestinationBottomBarBadge(var route: String ){

    object Home: DestinationBottomBarBadge("home")
    object Chat: DestinationBottomBarBadge("chat")
    object Setting: DestinationBottomBarBadge("setting")

}

@Composable
fun NavigationAppHostBottomBarBadge(navController: NavHostController) {


    NavHost(navController, startDestination = DestinationBottomBarBadge.Home.route) {


        composable(DestinationBottomBarBadge.Home.route) {
            HomeBottomBarBadgeScreen()
        }

        composable(DestinationBottomBarBadge.Chat.route){
            ChatBottomBarBadgeScreen()
        }

        composable(DestinationBottomBarBadge.Setting.route) {
            SettingBottomBarBadgeScreen()
        }



    }
}