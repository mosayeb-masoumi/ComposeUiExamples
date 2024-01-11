package com.example.compose_ui_examples

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose_ui_examples.composables.AutoSlider.AutoSliderScreen
import com.example.compose_ui_examples.composables.Button_Loading.ButtonLoadingScreen
import com.example.compose_ui_examples.composables.CallbackPage
import com.example.compose_ui_examples.composables.DialogCustom
import com.example.compose_ui_examples.composables.HomeIndex
import com.example.compose_ui_examples.composables.LoginPage1
import com.example.compose_ui_examples.composables.Network_image.NetworkImageScreen
import com.example.compose_ui_examples.composables.Notification.SimpleNotification
import com.example.compose_ui_examples.composables.SaveStateHandlerExample.Parnt_Child_LiveData.FirstSaveStateHandlerScreen
import com.example.compose_ui_examples.composables.SaveStateHandlerExample.Parnt_Child_LiveData.SecondSaveStateHandlerScreen
import com.example.compose_ui_examples.composables.SaveStateHandlerExample.SaveStateHandleObjectSerializable.SaveStateHandleSerializableScreen
import com.example.compose_ui_examples.composables.SaveStateHandlerExample.SaveStateHandlerScreen
import com.example.compose_ui_examples.composables.SaveStateHandlerExample.shareViewModel.SaveStateHandleScreenA
import com.example.compose_ui_examples.composables.SaveStateHandlerExample.shareViewModel.SaveStateHandleScreenB
import com.example.compose_ui_examples.composables.SaveStateHandlerExample.shareViewModel.SharedViewModel
import com.example.compose_ui_examples.composables.VisibilityGone
import com.example.compose_ui_examples.composables.add_to_list.AddToListScreen
import com.example.compose_ui_examples.composables.animation.AnimationScreen
import com.example.compose_ui_examples.composables.botombar_animation.BottomBarAnimationScreen
import com.example.compose_ui_examples.composables.bottombar_badge_lackner.BottomBarBadgeScreen
import com.example.compose_ui_examples.composables.theme_change.ChangeThemeScreen
import com.example.compose_ui_examples.composables.drop_down_menu.DropDownMenuScreen
import com.example.compose_ui_examples.composables.instagram_profile.InstagramProfileScreen
import com.example.compose_ui_examples.composables.language.LanguageChange
import com.example.compose_ui_examples.composables.login_video_bg.LoginVideoBgScreen
import com.example.compose_ui_examples.composables.onboarding.OnBoardingScreen
import com.example.compose_ui_examples.composables.parallax_toolbar.ParallaxToolbarScreen
import com.example.compose_ui_examples.composables.parcelable_example_save_state_handle.DetailParcelableScreen
import com.example.compose_ui_examples.composables.parcelable_example_save_state_handle.HomeParcelableScreen
import com.example.compose_ui_examples.composables.permission.PermissionPage
import com.example.compose_ui_examples.composables.search_in_list.SearchScreen
import com.example.compose_ui_examples.composables.share_viewmodel.DetailShareViewModelScreen
import com.example.compose_ui_examples.composables.share_viewmodel.HomeShareViewModelScreen
import com.example.compose_ui_examples.composables.share_viewmodel.MySharedViewModel
import com.example.compose_ui_examples.composables.sharepreference.SharePreferenceScreen
import com.example.compose_ui_examples.composables.tabbar_viewpager.ViewPagerTabBar
import com.example.compose_ui_examples.ui.theme.Compose_UI_ExamplesTheme
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


//        val config = resources.configuration
//        val locale = Locale("fa")
//        Locale.setDefault(locale)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
//            config.setLocale(locale)
//        else
//            config.locale = locale
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
//            createConfigurationContext(config)
//        resources.updateConfiguration(config, resources.displayMetrics)





        setContent {
            Compose_UI_ExamplesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //                    val navController = rememberNavController()
//                    NavigationAppHost(navController = navController)
//                    SimpleCallScreen()
//                    BroadcastGpsScreen()
//                    BoxKeyboard()
//                    BottomSheetScreen()
//                    NiceUi_1()
//                    AnimationScreen()
//                    GlassMorphismScreen()
//                    CollapsingToolbarScreen()
//                    DrawerNavigationMaterial3()
//                    LottieAnimationScreen()

//                    AnimatedShimmerScreen()

//                    FloatingActionButtonScreen()

//                    DrawerBottomBarScreen()

//                    UiEventScreen()

//                    PullRefreshSearchScreen()

//                    FlowSamplesScreen()

//                    NiceUI_2()
//                    ChipsScreen()
//                    SnackBarScreen()
//                    ChartsScreen()

//                    ImagePickerCamera()

//                    TabBarViewPagerM3()
//                    SingleImagePicker()
//                    MultipleImagePicker()

//                    BorderAnimated()

//                    TimerArc()
//                    ZoomRotateImageScreen()
//                    LoadingScreen()
//                    ButtonsScreen()

//                    CountDownAnimated()
//                    WebViewExample()

//                     StepperExample()

//                    AnimationTransition()

//                    TextExamples()
//                    DraggableListExample()

//                    ChangeThemeScreen()

                    LanguageChange()

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
    object KeyboardOverlapScreen : Destination("KeyboardOverlap_Screen")
    object SaveStateHandlerScreen : Destination("SaveStateHandler_Screen")
    object SimpleNotification : Destination("SimpleNotification")
    object DropDownMenuScreen : Destination("DropDownMenuScreen")
    object DeepLinkScreen : Destination("DeepLinkScreen")
    object FirstSaveStateHandlerScreen : Destination("FirstSaveStateHandlerScreen")
    object SecondSaveStateHandlerScreen : Destination("SecondSaveStateHandlerScreen")
    object SaveStateHandleScreenA : Destination("SaveStateHandleScreenA")
    object SaveStateHandleScreenB : Destination("SaveStateHandleScreenB")
    object SaveStateHandleSerializableScreen : Destination("SaveStateHandleSerializableScreen")
    object HomeParcelableScreen : Destination("HomeParcelableScreen")
    object DetailParcelableScreen : Destination("DetailParcelableScreen")


    object HomeShareViewModelScreen : Destination("HomeShareViewModelScreen")
    object DetailShareViewModelScreen : Destination("DetailShareViewModelScreen")
}


@Composable
fun NavigationAppHost(navController: NavHostController) {

    val ctx = LocalContext.current

    val shareViewModel: SharedViewModel = viewModel() // for saveStateHandleExample
    val myShareViewModel: MySharedViewModel = viewModel() // for shareViewModelExample

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
                OnBoardingScreen(elementId = elementId.toInt() ?: 0, age = age.toInt())
            }
        }

        composable(Destination.ViewPagerTabBar.route) { ViewPagerTabBar() }
        composable(Destination.VisibilityGone.route) { VisibilityGone() }
        composable(Destination.DialogCustom.route) { DialogCustom() }
        composable(Destination.CallbackPage.route) { CallbackPage() }
        composable(Destination.PermissionPage.route) { PermissionPage() }
        composable(Destination.SharePreferenceScreen.route) { SharePreferenceScreen() }
        composable(Destination.InstagramProfileScreen.route) { InstagramProfileScreen() }
        composable(Destination.BottomBarAnimationScreen.route) { BottomBarAnimationScreen() }
        composable(Destination.BottomBarBadgeScreen.route) { BottomBarBadgeScreen() }
        composable(Destination.LoginVideoBgScreen.route) { LoginVideoBgScreen() }
        composable(Destination.ButtonLoadingScreen.route) { ButtonLoadingScreen() }
        composable(Destination.AnimationScreen.route) { AnimationScreen() }
        composable(Destination.ParallaxToolbarScreen.route) { ParallaxToolbarScreen() }
        composable(Destination.SearchScreen.route) { SearchScreen() }
        composable(Destination.AddToListScreen.route) { AddToListScreen() }
        composable(Destination.NetworkImageScreen.route) { NetworkImageScreen() }
        composable(Destination.AutoSliderScreen.route) { AutoSliderScreen() }
        composable(Destination.SaveStateHandlerScreen.route) { SaveStateHandlerScreen(navController) }
        composable(Destination.SimpleNotification.route) { SimpleNotification() }
        composable(Destination.DropDownMenuScreen.route) { DropDownMenuScreen() }

        composable(Destination.FirstSaveStateHandlerScreen.route) {
            FirstSaveStateHandlerScreen(
                navController
            )
        }
        composable(Destination.SecondSaveStateHandlerScreen.route) {
            SecondSaveStateHandlerScreen(
                navController
            )
        }


        composable(Destination.SaveStateHandleScreenA.route) {
            SaveStateHandleScreenA(
                navController,
                sharedViewModel = shareViewModel
            )
        }
        composable(Destination.SaveStateHandleScreenB.route) {
            SaveStateHandleScreenB(
                navController,
                shareViewModel = shareViewModel
            )
        }


        composable(Destination.SaveStateHandleSerializableScreen.route) { SaveStateHandleSerializableScreen() }


        composable(Destination.HomeParcelableScreen.route) { HomeParcelableScreen(navController) }
        composable(Destination.DetailParcelableScreen.route) { DetailParcelableScreen(navController) }


        composable(Destination.HomeShareViewModelScreen.route) {
            HomeShareViewModelScreen(
                navController,
                myShareViewModel
            )
        }
        composable(Destination.DetailShareViewModelScreen.route) {
            DetailShareViewModelScreen(
                navController,
                myShareViewModel
            )
        }
    }
}