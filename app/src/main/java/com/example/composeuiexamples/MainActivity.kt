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
import com.example.composeuiexamples.composables.AutoSlider.AutoSliderScreen
import com.example.composeuiexamples.composables.Button_Loading.ButtonLoadingScreen
import com.example.composeuiexamples.composables.Network_image.NetworkImageScreen
import com.example.composeuiexamples.composables.add_to_list.AddToListScreen
import com.example.composeuiexamples.composables.animation.AnimationScreen
import com.example.composeuiexamples.composables.botombar_animation.BottomBarAnimationScreen
import com.example.composeuiexamples.composables.bottombar_badge_lackner.BottomBarBadgeScreen
import com.example.composeuiexamples.composables.instagram_profile.InstagramProfileScreen
import com.example.composeuiexamples.composables.permission.PermissionPage
import com.example.composeuiexamples.composables.login_register.RegisterLogin
import com.example.composeuiexamples.composables.login_video_bg.LoginVideoBgScreen
import com.example.composeuiexamples.composables.parallax_toolbar.ParallaxToolbarScreen
import com.example.composeuiexamples.composables.search_in_list.SearchScreen
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
                    val navController = rememberNavController()
                    NavigationAppHost(navController = navController)

//                    AnimationScreen()
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
    object LoginVideoBgScreen : Destination("loginVideoBg_Screen")
    object ButtonLoadingScreen : Destination("buttonLoading_Screen")
    object AnimationScreen : Destination("animation_Screen")
    object ParallaxToolbarScreen : Destination("parallax_toolbar_Screen")
    object SearchScreen : Destination("Search_Screen")
    object AddToListScreen : Destination("AddToList_Screen")
    object NetworkImageScreen : Destination("NetworkImage_Screen")
    object AutoSliderScreen : Destination("AutoSlider_Screen")
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
        composable(Destination.LoginVideoBgScreen.route) {LoginVideoBgScreen() }
        composable(Destination.ButtonLoadingScreen.route) {ButtonLoadingScreen() }
        composable(Destination.AnimationScreen.route) {AnimationScreen() }
        composable(Destination.ParallaxToolbarScreen.route) { ParallaxToolbarScreen() }
        composable(Destination.SearchScreen.route) { SearchScreen() }
        composable(Destination.AddToListScreen.route) {AddToListScreen() }
        composable(Destination.NetworkImageScreen.route) {NetworkImageScreen() }
        composable(Destination.AutoSliderScreen.route) {AutoSliderScreen() }
    }
}

