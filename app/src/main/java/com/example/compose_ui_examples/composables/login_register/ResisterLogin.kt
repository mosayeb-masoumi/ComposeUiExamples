package com.example.compose_ui_examples.composables.login_register

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose_ui_examples.composables.login_register.screens.LogInScreen
import com.example.compose_ui_examples.composables.login_register.screens.SignUpScreen
import com.example.compose_ui_examples.composables.login_register.screens.TermsAndConditionScreen



@Composable
fun RegisterLogin(){
    val navController = rememberNavController()
    NavigationAppHostRegisterLogin(navController = navController)

//    LogInScreen()
}



sealed class DestinationRegisterLogin(var route: String ){

    object SignUp: DestinationRegisterLogin("sign_up")
    object TermsAndConditions: DestinationRegisterLogin("terms_and_conditions")
    object LogIn: DestinationRegisterLogin("log_in")

}

@Composable
fun NavigationAppHostRegisterLogin(navController: NavHostController) {

    NavHost(navController, startDestination = DestinationRegisterLogin.SignUp.route) {

        composable(DestinationRegisterLogin.SignUp.route) {
            SignUpScreen(navController)
        }

        composable(DestinationRegisterLogin.TermsAndConditions.route){
            TermsAndConditionScreen()
        }

        composable(DestinationRegisterLogin.LogIn.route){
            LogInScreen(navController)
        }

    }
}