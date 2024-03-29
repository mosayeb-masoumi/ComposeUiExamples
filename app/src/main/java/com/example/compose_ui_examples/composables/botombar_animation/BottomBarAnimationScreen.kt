package com.example.compose_ui_examples.composables.botombar_animation

import android.annotation.SuppressLint
import android.transition.Scene
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.compose_ui_examples.Destination
import com.example.compose_ui_examples.composables.botombar_animation.Destination.DestinationBottomBarAnimation
import com.example.compose_ui_examples.composables.botombar_animation.Destination.NavigationAppHostBottomBarAnimation
import com.example.compose_ui_examples.ui.theme.Purple200
import com.example.compose_ui_examples.ui.theme.Purple500

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomBarAnimationScreen() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomBarAnimation(navController = navController)}

    ) {
        NavigationAppHostBottomBarAnimation(navController = navController)
    }
}


@Composable
fun BottomBarAnimation(navController: NavHostController) {

    val screens = listOf(
        DestinationBottomBarAnimation.HomeBottomBarAnimation,
        DestinationBottomBarAnimation.ProfileBottomBarAnimation,
        DestinationBottomBarAnimation.ReportBottomBarAnimation,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Row(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 8.dp, bottom = 8.dp)
            .background(Color.White)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        screens.forEach { screen ->

            AddItem(
                screen = screen,
                currentDestinationBottomBarAnimation = currentDestination,
                navController = navController
            )
        }
    }
}


@Composable
fun RowScope.AddItem(
    screen: DestinationBottomBarAnimation,   //
    currentDestinationBottomBarAnimation: NavDestination?,
    navController: NavHostController,
) {
    val selected =
        currentDestinationBottomBarAnimation?.hierarchy?.any { it.route == screen.route } == true

    val background = if (selected) Purple500.copy(alpha = 0.6f) else Color.Transparent
    val contentColor = if (selected) Color.White else Color.Black

    Box(
        modifier = Modifier
            .height(40.dp)
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            })
    ) {

        Row(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            Icon(
                painter =
                painterResource(id = if (selected) screen.icon_focused else screen.icon),
                contentDescription = "icon",
                tint = contentColor
            )

            AnimatedVisibility(visible = selected) {
                Text(
                    text = screen.title,
                    color = contentColor
                )
            }
        }
    }
}


@Preview
@Composable
fun BottomBarAnimationScreenPreview() {
    BottomBarAnimationScreen()
}
// BottomBarScreen = DestinationBottomBarAnimation