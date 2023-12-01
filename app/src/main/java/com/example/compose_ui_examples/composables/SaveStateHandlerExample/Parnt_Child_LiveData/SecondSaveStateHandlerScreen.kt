package com.example.compose_ui_examples.composables.SaveStateHandlerExample.Parnt_Child_LiveData

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.compose_ui_examples.composables.login_register.components.ButtonComponent
import com.example.compose_ui_examples.composables.login_register.components.NormalTextComponent


@Composable
fun SecondSaveStateHandlerScreen(navController: NavHostController) {


    val firstScreenResult = navController.previousBackStackEntry
        ?.savedStateHandle
//        ?.getLiveData<String>("countFromParent_key")?.observeAsState(initial = 0)
        ?.getStateFlow("countFromFirstScreen_key" ,5)?.collectAsState(initial = 5)

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp)
    )
    {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            NormalTextComponent(value = "Screen Test B-------> ${firstScreenResult?.value}")
            ButtonComponent(value = "back to screen A", onButtonClicked = {

                navController.previousBackStackEntry
                    ?.savedStateHandle
                    ?.set("countFromSecondScreen_key", 5)

                navController.navigateUp()
            })
        }
    }
}
