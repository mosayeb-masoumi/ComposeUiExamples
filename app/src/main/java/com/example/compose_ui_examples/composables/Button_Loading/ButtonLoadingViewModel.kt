package com.example.compose_ui_examples.composables.Button_Loading

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ButtonLoadingViewModel : ViewModel(){



//    private val _result = mutableStateOf("initial value")
//    val result : State<String> = _result
//
//    private val _isLoading = mutableStateOf(false)
//    val isLoading : State<Boolean> = _isLoading


    private val _result = MutableStateFlow("Initial Value")
    val result: StateFlow<String> = _result


    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun sendDataToServer(value: String) {

        _isLoading.value = true
        viewModelScope.launch() {
            delay(3000L)
            _result.value = "ok"
            _isLoading.value = false
        }

    }
}