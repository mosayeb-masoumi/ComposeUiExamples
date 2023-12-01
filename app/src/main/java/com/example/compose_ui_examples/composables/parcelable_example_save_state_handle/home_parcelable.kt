package com.example.compose_ui_examples.composables.parcelable_example_save_state_handle

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.compose_ui_examples.Destination

@Composable
fun HomeParcelableScreen(navController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "Home Screen")

        Button(onClick = {

            val person = PersonParcelableModel(firstName = "mosayeb" , lastName = "masoumi")
            navController.currentBackStackEntry?.savedStateHandle?.set(
                key ="person",
                value = person
            )
            navController.navigate(Destination.DetailParcelableScreen.route)

        }) {
            Text(text = "send object to detail screen")
        }
    }
}