package com.example.compose_ui_examples.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.compose_ui_examples.Destination


@Composable
fun HomeIndex(navController: NavHostController) {


    LazyColumn(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp)
    ) {

        item {
            Button(onClick = {
                navController.navigate(Destination.Login.route)
            }, modifier = Modifier.padding(all = 10.dp)) {
                Text("Login Page", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }

        item {
            Button(onClick = {
                navController.navigate(Destination.OnBoarding.createRoute(1, 25))
            }, modifier = Modifier.padding(bottom = 10.dp)) {
                Text("OnBoarding Page", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }

        item {
            Button(onClick = {
                navController.navigate(Destination.ViewPagerTabBar.route)
            }, modifier = Modifier.padding(bottom = 10.dp)) {
                Text("ViewPager TabBar Page", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }


        item {
            Button(onClick = {
                navController.navigate(Destination.VisibilityGone.route)
            }, modifier = Modifier.padding(bottom = 10.dp)) {
                Text("Visibility Gone Page", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }

        item {
            Button(onClick = {
                navController.navigate(Destination.DialogCustom.route)
            }, modifier = Modifier.padding(bottom = 10.dp)) {
                Text("Dialog Custom Page", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }


        item {
            Button(onClick = {
                navController.navigate(Destination.CallbackPage.route)
            }, modifier = Modifier.padding(bottom = 10.dp)) {
                Text("Callback Page", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }

        item {
            Button(onClick = {
                navController.navigate(Destination.PermissionPage.route)
            }, modifier = Modifier.padding(bottom = 10.dp)) {
                Text("Permission Page", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }

        item {
            Button(onClick = {
                navController.navigate(Destination.SharePreferenceScreen.route)
            }, modifier = Modifier.padding(bottom = 10.dp)) {
                Text("SharePrefrence Page", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }

        item {
            Button(onClick = {
                navController.navigate(Destination.InstagramProfileScreen.route)
            }, modifier = Modifier.padding(bottom = 10.dp)) {
                Text("InstagramProfile Page", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }

        item {
            Button(onClick = {
                navController.navigate(Destination.BottomBarAnimationScreen.route)
            }, modifier = Modifier.padding(bottom = 10.dp)) {
                Text("BottomBar Animation Page", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }

        item {
            Button(onClick = {
                navController.navigate(Destination.BottomBarBadgeScreen.route)
            }, modifier = Modifier.padding(bottom = 10.dp)) {
                Text("BottomBar Badge Page", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }


        item {
            Button(onClick = {
                navController.navigate(Destination.LoginVideoBgScreen.route)
            }, modifier = Modifier.padding(bottom = 10.dp)) {
                Text("Login Video Bg Page", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }

        item {
            Button(onClick = {
                navController.navigate(Destination.ButtonLoadingScreen.route)
            }, modifier = Modifier.padding(bottom = 10.dp)) {
                Text("Button Loading Screen", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }

        item {
            Button(onClick = {
                navController.navigate(Destination.AnimationScreen.route)
            }, modifier = Modifier.padding(bottom = 10.dp)) {
                Text("Animation Screen", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }



        item {
            Button(onClick = {
                navController.navigate(Destination.ParallaxToolbarScreen.route)
            }) {
                Text(text = "ParraxToolbar", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }


        item {
            Button(onClick = {
                navController.navigate(Destination.SearchScreen.route)
            }) {
                Text(text = "SearchScreen", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }

        item {
            Button(onClick = {
                navController.navigate(Destination.AddToListScreen.route)
            }) {
                Text(text = "Add to list screen", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }


        item {
            Button(onClick = {
                navController.navigate(Destination.NetworkImageScreen.route)
            }) {
                Text(text = "Network Image screen", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }

        item {
            Button(onClick = {
                navController.navigate(Destination.AutoSliderScreen.route)
            }) {
                Text(text = "Auto Slider Screen", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }

        item {
            Button(onClick = {
                navController.navigate(Destination.KeyboardOverlapScreen.route)
            }) {
                Text(text = "Keyboard Overlap Screen", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }

        item {
            Button(onClick = {
                navController.navigate(Destination.SaveStateHandlerScreen.route)
            }) {
                Text(text = "SaveStateHandler Screen", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }

        item {
            Button(onClick = {
                navController.navigate(Destination.SimpleNotification.route)
            }) {
                Text(text = "Simple Notification Screen", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }

        item {
            Button(onClick = {
                navController.navigate(Destination.DropDownMenuScreen.route)
            }) {
                Text(text = "DropDownMenu Screen", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }

        item {
            Button(onClick = {
                navController.navigate(Destination.DeepLinkScreen.route)
            }) {
                Text(text = "Deep Link Screen", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }


        item {
            Button(onClick = {
                navController.navigate(Destination.HomeParcelableScreen.route)
            }) {
                Text(text = "parcelable object", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }

        item {
            Button(onClick = {
                navController.navigate(Destination.HomeShareViewModelScreen.route)
            }) {
                Text(text = "Shared viewModel", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }

    }
}

