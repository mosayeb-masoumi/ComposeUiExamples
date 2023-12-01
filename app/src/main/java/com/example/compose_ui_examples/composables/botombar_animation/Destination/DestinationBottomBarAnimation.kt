package com.example.compose_ui_examples.composables.botombar_animation.Destination

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compose_ui_examples.R
import com.example.compose_ui_examples.composables.botombar_animation.screens.*

sealed class DestinationBottomBarAnimation(
    val route: String,
    val title: String,
    val icon: Int,
    val icon_focused: Int
) {

    // for home
    object HomeBottomBarAnimation : DestinationBottomBarAnimation(
        route = "home",
        title = "Home",
        icon = R.drawable.ic_bottom_home,
        icon_focused = R.drawable.ic_bottom_home_focused
    )

    // for report
    object ReportBottomBarAnimation : DestinationBottomBarAnimation(
        route = "report",
        title = "Report",
        icon = R.drawable.ic_bottom_report,
        icon_focused = R.drawable.ic_bottom_report_focused
    )

    // for profile
    object ProfileBottomBarAnimation : DestinationBottomBarAnimation(
        route = "profile",
        title = "Profile",
        icon = R.drawable.ic_bottom_profile,
        icon_focused = R.drawable.ic_bottom_profile_focused
    )
}


@Composable
fun NavigationAppHostBottomBarAnimation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = DestinationBottomBarAnimation.HomeBottomBarAnimation.route
    ) {

        composable(DestinationBottomBarAnimation.HomeBottomBarAnimation.route) { HomeBottomBarAnimationPage() }
        composable(DestinationBottomBarAnimation.ProfileBottomBarAnimation.route) { ProfileBottomBarAnimationPage() }
        composable(DestinationBottomBarAnimation.ReportBottomBarAnimation.route) { ReportBottomBarAnimationPage() }

    }
}

