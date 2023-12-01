package com.example.compose_ui_examples.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun CallbackPage() {


    val eventResult = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        MyButton { backedResult ->
            eventResult.value = backedResult
        }

        Text(eventResult.value)
    }
}

@Composable
fun MyButton(onEventCallback: (String) -> Unit) {

    Button(onClick = {
        onEventCallback("ITS THE STRING")
    }) {
        Text(text = "Click here to send back string to parent")
    }
}