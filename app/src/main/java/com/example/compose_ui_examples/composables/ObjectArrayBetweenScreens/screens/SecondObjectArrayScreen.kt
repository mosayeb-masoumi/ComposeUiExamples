package com.example.compose_ui_examples.composables.ObjectArrayBetweenScreens.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.compose_ui_examples.ButtonComponent

@Composable
fun SecondObjectArrayScreen(navController: NavHostController, myModel: MyModel?, myList: List<MyModel>) {

    var a = myModel
    var b = a

    var c = myList
    var d = c;

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

            ButtonComponent(value = "back to screen A", onButtonClicked = {

                navController.navigateUp()
            })
        }
    }
}