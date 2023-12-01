package com.example.compose_ui_examples.composables.login_register.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
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
fun SignUpScreen(navController: NavHostController) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(28.dp)
    ) {

        Column(modifier = Modifier.fillMaxSize()) {
            NormalTextComponent(value = stringResource(id = R.string.hello))
            HeadingTextComponent(value = stringResource(id = R.string.create_account))
            Spacer(modifier = Modifier.height(20.dp))
            MyTextFiled(
                labelValue = stringResource(id = R.string.first_name),
                leadingIcon = Icons.Default.Person
            )

            MyTextFiled(
                labelValue = stringResource(id = R.string.last_name),
                leadingIcon = Icons.Default.Person
            )

            MyTextFiled(
                labelValue = stringResource(id = R.string.email),
                leadingIcon = Icons.Default.Email
            )

            PasswordTextFiled(
                labelValue = stringResource(id = R.string.password),
                leadingIcon = Icons.Default.Lock
            )

            CheckBoxComponent(value = stringResource(R.string.terms_and_conditions),
                onTextSelected = {
                  navController.navigate(DestinationRegisterLogin.TermsAndConditions.route)
                })

            Spacer(modifier = Modifier.height(80.dp))

            ButtonComponent(value = stringResource(R.string.register) , onButtonClicked = {})

            Spacer(modifier = Modifier.height(10.dp))

            DividerTextComponent()

            ClickableLoginTextComponent(tryingToLogin = true, onTextSelected = {
                navController.navigate(DestinationRegisterLogin.LogIn.route)
            })
        }

    }
}