package com.example.compose_ui_examples.composables.bottombar_badge_lackner

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.compose_ui_examples.composables.bottombar_badge_lackner.destination.NavigationAppHostBottomBarBadge

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomBarBadgeScreen() {

    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBarBadge(
                items = listOf(
                    BottomNavItem(
                        name = "Home",
                        route = "home" ,
                        icon = Icons.Default.Home,
                        badgeCount = 0
                    ),
                    BottomNavItem(
                        name = "Chat",
                        route = "chat" ,
                        icon = Icons.Default.Notifications,
                        badgeCount = 123
                    ),
                    BottomNavItem(
                        name = "Setting",
                        route = "setting" ,
                        icon = Icons.Default.Settings,
                        badgeCount = 0
                    ),
                ),
                navController = navController,
    //            onItemClick =
                onItemClick = {
                    navController.navigate(it.route)
                }
            )
        }
    ){
        NavigationAppHostBottomBarBadge(navController = navController)
    }
}


@Composable
fun BottomNavigationBarBadge(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {

    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.DarkGray,
        elevation = 5.dp
    ) {

        items.forEach { item ->

            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Gray,
                icon = {

                    Column(horizontalAlignment = CenterHorizontally) {
                        if (item.badgeCount > 0) {
                            BadgedBox(
                                badge = { Text(
                                    modifier =Modifier.padding(all = 2.dp).background(color = Color.Red, shape = RoundedCornerShape(10.dp)),
                                    text = item.badgeCount.toString() , color = Color.White) }
                            ) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.name
                                )
                            }
                        } else {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.name
                            )
                        }

                        if (selected) {
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }
                    }
                }
            )
        }
    }
}