package com.example.compose_ui_examples.composables.flow_samples

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FlowViewModel : ViewModel() {

    //mutableStateOf
    private val _mutableStateOf = mutableStateOf(FlowUIState())
    val mutableStateOf: State<FlowUIState> = _mutableStateOf


    //StateFlow
    private val _stateFlow = MutableStateFlow(FlowUIState())
    val stateFlow = _stateFlow.asStateFlow()


    //SharedFlow
    private val _sharedFlow = MutableSharedFlow<FlowUIState>()
    val sharedFlow = _sharedFlow.asSharedFlow()


    fun onEvent(event: FlowUIEvent) {
        when (event) {

            is FlowUIEvent.MutableStateOfClicked -> {
               _mutableStateOf.value = _mutableStateOf.value.copy(
                   mutableStateOfData = "simple mutableStateOf",
                   mutableStateFlowData = "",
                   mutableSharedFlowData = ""
               )
            }

            is FlowUIEvent.MutableStateFlowClicked -> {
               _stateFlow.value = stateFlow.value.copy(
                   mutableStateOfData = "",
                   mutableStateFlowData = "stateFlow",
                   mutableSharedFlowData = ""
               )
            }

            is FlowUIEvent.MutableSharedFlowClicked -> {
                val sharedFlow = FlowUIState(
                    mutableStateOfData = "",
                    mutableStateFlowData = "",
                    mutableSharedFlowData = "sharedFlow"
                )

                viewModelScope.launch {
                    _sharedFlow.emit(sharedFlow)
                }

            }
        }
    }

}