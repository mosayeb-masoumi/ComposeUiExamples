package com.example.compose_ui_examples.composables.SaveStateHandlerExample.shareViewModel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.compose_ui_examples.Destination
import com.example.compose_ui_examples.composables.login_register.components.ButtonComponent

@Composable
fun SaveStateHandleScreenA(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {


    var inputValue by remember { mutableStateOf(0) }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp)
    ) {

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

            Column(modifier = Modifier.fillMaxSize().padding(50.dp)) {
                ButtonComponent(value = "goto screen b") {

                    inputValue = 15
                    sharedViewModel.savedStateHandle.set("intValue", inputValue)
                    navController.navigate(Destination.SaveStateHandleScreenB.route)
                }

                Text(text = inputValue.toString())
            }

        }


    }
}


class SharedViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    val savedStateHandle = savedStateHandle
}


