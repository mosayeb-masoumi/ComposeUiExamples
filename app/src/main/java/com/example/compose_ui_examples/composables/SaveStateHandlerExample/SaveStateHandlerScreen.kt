package com.example.compose_ui_examples.composables.SaveStateHandlerExample

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController

@Composable
fun SaveStateHandlerScreen(navController: NavHostController) {


    //example1

    var count by rememberSaveable { mutableStateOf(0) }
    BackHandler() {
        var a = 5
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green.copy(alpha = 0.4f))
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(50.dp)
    ) {

        Text(text = "in this example we increase the" +
                " number but when rotate the screen we'll" +
                " see data loose for preventing it we use saveStateHandler ")

        Button(onClick = {
          count++
        }) {
            Text(text = "Increment")
        }

        Text(text = "$count")
    }

}

