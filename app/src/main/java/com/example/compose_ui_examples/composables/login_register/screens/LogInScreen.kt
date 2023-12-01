package com.example.compose_ui_examples.composables.login_register.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Message
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.compose_ui_examples.R
import com.example.compose_ui_examples.composables.login_register.DestinationRegisterLogin
import com.example.compose_ui_examples.composables.login_register.components.*

@Composable
fun LogInScreen(navController: NavHostController) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(28.dp)
    ) {

        Column(modifier = Modifier.fillMaxSize()) {

            NormalTextComponent(value = stringResource(R.string.login))
            NormalTextComponent(value = stringResource(R.string.welcome_back))
            Spacer(modifier = Modifier.height(20.dp))
            MyTextFiled(labelValue = stringResource(R.string.email), leadingIcon = Icons.Default.Message)
            PasswordTextFiled(labelValue = stringResource(R.string.password), leadingIcon = Icons.Default.Lock)
            Spacer(modifier = Modifier.height(40.dp))
            UnderLineTextComponent(value = stringResource(R.string.forget_password))
            Spacer(modifier = Modifier.height(40.dp))
            ButtonComponent(value = stringResource(id = R.string.login), onButtonClicked = {})
            Spacer(modifier = Modifier.height(20.dp))
            DividerTextComponent()

            ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
                navController.navigate(DestinationRegisterLogin.SignUp.route)
            })

        }
    }
}