package com.example.compose_ui_examples.composables.drawer_material3

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun DrawerNavigationMaterial3() {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)


    val items = listOf(
        DrawerItem(icon = Icons.Default.Favorite, label = "Likes", secondaryLabel = "64"),
        DrawerItem(icon = Icons.Default.Face, label = "Messages", secondaryLabel = "25"),
        DrawerItem(icon = Icons.Default.Email, label = "Email", secondaryLabel = "11"),
        DrawerItem(icon = Icons.Default.Settings, label = "Settings", secondaryLabel = "70")
    )
    var selectedItem by remember { mutableStateOf(items[0]) }
    val scope = rememberCoroutineScope()


    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 64.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Header", fontSize = 20.sp)
                }

                items.forEach { item ->
                    NavigationDrawerItem(
                        label = { Text(text = item.label) },
                        selected = item == selectedItem,
                        onClick = {
                            selectedItem = item
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                        badge = { Text(text = item.secondaryLabel) },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)

                    )
                }
            }
        },


        content = {

            MyContent2(onMenuItemClicked = {
                scope.launch {
                    drawerState.open()
                }
            })
        }
    )

}

data class DrawerItem(
    val icon: ImageVector,
    val label: String,
    val secondaryLabel: String
)


//@Composable
//fun MyContent(
//    onClick: () -> Unit
//) {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//
//        Text(text = ">>> Swipe >>>")
//        Spacer(modifier = Modifier.height(20.dp))
//        Button(onClick = {
//            onClick.invoke()
//        }) {
//            Text(text = "Click to open drawer")
//        }
//    }
//}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyContent2(
    onMenuItemClicked: () -> Unit
) {
    Scaffold(
        topBar = {

            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
                        onMenuItemClicked.invoke()
                    }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "")
                    }
                },
                title = { Text(text = "Top Series") }
            )
        },

        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(color = Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Bottom bar" , color = Color.Red)
            }
        }

    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(50) {
                ListItem(
                    headlineContent = { Text(text = "Item $it") },
                    leadingContent = {
                        Icon(Icons.Default.Face, contentDescription = "")
                    }
                )
            }
        }

    }
}