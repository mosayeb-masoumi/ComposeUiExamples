package com.example.compose_ui_examples.composables.`UiState-UiEvent`

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MyUiStateViewModel:ViewModel() {

    // simple state
//     val uiState = mutableStateOf(MyUIState())


    // stateFlow
    private val _uiState = MutableStateFlow(MyUIState())
    val uiState = _uiState.asStateFlow()


    fun onEvent(event: MyUiEvent){

        when(event){

            is MyUiEvent.ButtonClicked -> {
                _uiState.value = uiState.value.copy(
                    showLoading = true
                )
            }
        }
    }
}