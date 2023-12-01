package com.example.compose_ui_examples.composables.flow_samples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun FlowSamplesScreen(flowViewModel: FlowViewModel = viewModel()) {


    val state = flowViewModel.mutableStateOf.value



    val stateFlow = flowViewModel.stateFlow.collectAsState()
//    or
//    val stateFlow by flowViewModel.stateFlow.collectAsState()



    var sharedFlow by remember { mutableStateOf("") }
    LaunchedEffect(key1 = true) {
        flowViewModel.sharedFlow.collectLatest { event ->
          sharedFlow = event.mutableSharedFlowData
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Blue.copy(alpha = 0.4f)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // simple mutable stateOf
        Button(onClick = {
            flowViewModel.onEvent(FlowUIEvent.MutableStateOfClicked)
        }) {
            Text(text = "mutableStateOf()")
        }

        Text(text = "mutableStateOf ${state.mutableStateOfData}")




        // stateFlow
        Button(onClick = {
            flowViewModel.onEvent(FlowUIEvent.MutableStateFlowClicked)
        }) {
            Text(text = "MutableStateFlow()")
        }

        Text(text = "mutableStateOf ${stateFlow.value.mutableStateFlowData}")
//        or
//        Text(text = "mutableStateOf ${stateFlow.mutableStateFlowData}")





        // sgharedFlow
        Button(onClick = {
            flowViewModel.onEvent(FlowUIEvent.MutableSharedFlowClicked)
        }) {
            Text(text = "MutableSharedFlow")
        }
        Text(text = "mutableStateOf $sharedFlow")

    }
}