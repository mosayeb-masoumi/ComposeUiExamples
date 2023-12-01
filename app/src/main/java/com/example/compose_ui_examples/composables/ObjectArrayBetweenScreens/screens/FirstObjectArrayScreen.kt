package com.example.compose_ui_examples.composables.ObjectArrayBetweenScreens.screens

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Surface
import androidx.compose.ui.Alignment
import com.example.compose_ui_examples.ButtonComponent
import com.example.compose_ui_examples.composables.ObjectArrayBetweenScreens.destination.DestinationObjectArray
import com.google.gson.Gson

@Composable
fun FirstObjectArrayScreen(navController: NavHostController) {


    val myModel = MyModel(name = "Hassan", age = 25)

    val myList = listOf(
        MyModel(name = "Hassan", age = 25),
        MyModel(name = "reza", age = 11),
        MyModel(name = "mina", age = 17),
    )


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp)
    ) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {


            ButtonComponent(
                value = "send data model to screen B",
                onButtonClicked = {
                    val gson = Gson()
                    val myModelJson = gson.toJson(myModel)

                    val gson2 = Gson()
                    val myListJson = gson2.toJson(myList)

                    navController.navigate(DestinationObjectArray.Second.createRoute(myModelJson , myListJson))
                })

        }

    }
}



data class MyModel(
    val name: String ,
    val age: Int,
)
