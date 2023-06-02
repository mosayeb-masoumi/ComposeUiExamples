package com.example.composeuiexamples

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeuiexamples.composables.*
import com.example.composeuiexamples.composables.botombar_animation.BottomBarAnimationScreen
import com.example.composeuiexamples.composables.bottombar_badge_lackner.BottomBarBadgeScreen
import com.example.composeuiexamples.composables.instagram_profile.InstagramProfileScreen
import com.example.composeuiexamples.composables.permission.PermissionPage
import com.example.composeuiexamples.composables.register_login.RegisterLogin
import com.example.composeuiexamples.composables.register_login.screens.SignUpScreen
import com.example.composeuiexamples.composables.sharepreference.SharePreferenceScreen
import com.example.composeuiexamples.ui.theme.ComposeUIExamplesTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUIExamplesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    val navController = rememberNavController()
//                    NavigationAppHost(navController = navController)


                    RegisterLogin()

                }
            }
        }
    }
}





sealed class Destination(var route: String) {
    object Home : Destination("home")
    object Login : Destination("login")
    object OnBoarding : Destination("onboarding/{elementId}/{age}") {
        fun createRoute(elementId: Int, age: Int) = "onboarding/$elementId/$age"
    }

    object ViewPagerTabBar : Destination("viewpager_tabbar")
    object VisibilityGone : Destination("visibility_gone")
    object DialogCustom : Destination("dialog_custom")
    object CallbackPage : Destination("callback_page")
    object PermissionPage : Destination("permission_page")
    object SharePreferenceScreen : Destination("shareprefrence_page")
    object InstagramProfileScreen : Destination("InstagramProfile_Screen")
    object BottomBarAnimationScreen : Destination("BottomBarAnimation_Screen")
    object BottomBarBadgeScreen : Destination("BottomBarBadge_Screen")
}


@Composable
fun NavigationAppHost(navController: NavHostController) {

    val ctx = LocalContext.current
    // startDestination = "home"
    NavHost(navController = navController, startDestination = Destination.Home.route) {
        composable(Destination.Home.route) { HomeIndex(navController) }
        composable(Destination.Login.route) { LoginPage1(navController) }
        composable(Destination.OnBoarding.route) { navBackStackEntry ->
            val elementId = navBackStackEntry.arguments?.getString("elementId")
            val age = navBackStackEntry.arguments?.getString("age")
            var ss = age
            if (elementId == null || age == null) {
                Toast.makeText(ctx, "ElementId or Age required", Toast.LENGTH_LONG).show()
            } else {
                OnBoardingPage1(elementId = elementId.toInt(), age = age.toInt())
            }
        }

        composable(Destination.ViewPagerTabBar.route) { ViewPagerTabBar() }
        composable(Destination.VisibilityGone.route) { VisibilityGone() }
        composable(Destination.DialogCustom.route) { DialogCustom() }
        composable(Destination.CallbackPage.route) { CallbackPage() }
        composable(Destination.PermissionPage.route) { PermissionPage() }
        composable(Destination.SharePreferenceScreen.route) { SharePreferenceScreen() }
        composable(Destination.InstagramProfileScreen.route) {InstagramProfileScreen() }
        composable(Destination.BottomBarAnimationScreen.route) {BottomBarAnimationScreen() }
        composable(Destination.BottomBarBadgeScreen.route) {BottomBarBadgeScreen() }
    }
}

