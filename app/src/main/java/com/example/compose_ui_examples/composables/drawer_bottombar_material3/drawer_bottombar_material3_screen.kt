package com.example.compose_ui_examples.composables.drawer_bottombar_material3

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemColors
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compose_ui_examples.R
import kotlinx.coroutines.launch

@Composable
fun DrawerBottomBarScreen() {


    val navController = rememberNavController()
    NavigationAppHostDrawerBottomBar(navController = navController)



    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val items = listOf(
        MyDrawerItem(icon = Icons.Default.Home, label = "Home", secondaryLabel = "64"),
        MyDrawerItem(icon = Icons.Default.Message, label = "Message", secondaryLabel = "25"),
        MyDrawerItem(icon = Icons.Default.Chat, label = "Chat", secondaryLabel = "11"),)
    var selectedItem by remember { mutableStateOf(items[0]) }
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {

                // header
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 64.dp),
                    contentAlignment = Alignment.Center
                ) {

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            modifier = Modifier
                                .size(100.dp)
                                .clip(shape = CircleShape),
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = ""
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "user name", textAlign = TextAlign.Center
                        )
                    }

                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(horizontal = 10.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(color = Color.Blue.copy(alpha = 0.5f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "list of items", color = Color.White, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.height(10.dp))

                items.forEach { item ->
                    NavigationDrawerItem(
                        label = { Text(text = item.label) },
                        selected = item == selectedItem,
                        onClick = {
                            selectedItem = item
                            scope.launch {
                                drawerState.close()
                                when (selectedItem.label) {
                                    "Home" -> {
                                        navController.navigate(DrawerBottomBarDestination.HomeDrawerBottomBarScreen.route)
                                    }
                                    "Message" -> {
                                        navController.navigate(DrawerBottomBarDestination.MessageDrawerBottomBarScreen.route)
                                    }
                                    "Chat" -> {
                                        navController.navigate(DrawerBottomBarDestination.ChatDrawerBottomBarScreen.route)
                                    }
                                }
                            }
                        },
                        icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                        badge = { Text(text = item.secondaryLabel) },
                        modifier = Modifier
                            .padding(NavigationDrawerItemDefaults.ItemPadding)
                            .background(color = Color.Transparent),
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = Color.Transparent,
                            unselectedContainerColor = Color.Transparent
                        )
                       )
                }

            }
        },


        // content of aplication
        content = {
            AppContent(
                navController,
                onMenuItemClicked = {
                scope.launch {
                    drawerState.open()
                }
            })
        }
    )
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent(
    navController: NavHostController,
    onMenuItemClicked: () -> Unit) {


//    val navController = rememberNavController()
//    NavigationAppHostDrawerBottomBar(navController = navController)

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
                        onMenuItemClicked.invoke()
                    }) {
                        Icon(Icons.Default.Menu, contentDescription = "")
                    }
                },
                title = { Text(text = "") }
            )
        },


        bottomBar = {
            MyBottomBar(
                items = listOf(
                    MyBottomNavItem(
                        name = "Home",
                        route = DrawerBottomBarDestination.HomeDrawerBottomBarScreen.route,  // route name we defined in destination
                        icon = Icons.Default.Home,
                        badgeCount = 0
                    ),
                    MyBottomNavItem(
                        name = "Message",
                        route = DrawerBottomBarDestination.MessageDrawerBottomBarScreen.route,  // route name we defined in destination
                        icon = Icons.Default.Notifications,
                        badgeCount = 123
                    ),
                    MyBottomNavItem(
                        name = "Chat",
                        route = DrawerBottomBarDestination.ChatDrawerBottomBarScreen.route,  // route name we defined in destination
                        icon = Icons.Default.Settings,
                        badgeCount = 0
                    ),
                ),

                navController = navController,

                onItemClick = {
                   var ss = it.route
                    navController.navigate(it.route)
                }
            )
        }


    )
    {

        NavigationAppHostDrawerBottomBar(navController = navController)
    }
}


data class MyDrawerItem(
    val icon: ImageVector,
    val label: String,
    val secondaryLabel: String
)

data class MyBottomNavItem(
    val name:String,
    val route:String ,
    val icon: ImageVector,
    val badgeCount: Int
)