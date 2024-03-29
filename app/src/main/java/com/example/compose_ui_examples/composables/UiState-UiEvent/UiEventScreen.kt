package com.example.compose_ui_examples.composables.`UiState-UiEvent`

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun UiEventScreen(myViewModel: MyUiStateViewModel = viewModel()) {


//    val showLoading = myViewModel.uiState.value.showLoading

    // using stateFlow
    val uiState by myViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        AnimatedVisibility(visible = uiState.showLoading) {
           CircularProgressIndicator()
        }

        Button(onClick = {
             myViewModel.onEvent(MyUiEvent.ButtonClicked)
        }) {
            Text(text = "Get data")
        }

    }
}