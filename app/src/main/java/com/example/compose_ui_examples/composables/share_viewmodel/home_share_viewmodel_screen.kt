package com.example.compose_ui_examples.composables.share_viewmodel

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
fun HomeShareViewModelScreen(navController: NavHostController, shareViewModel: MySharedViewModel) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "Home Screen")

        Button(onClick = {

            val person = PersonShareModel(firstName = "mosayeb" , lastName = "masoumi")
            shareViewModel.addPerson(person)

            navController.navigate(Destination.DetailShareViewModelScreen.route)

        }) {
            Text(text = "send object to detail screen")
        }
    }
}