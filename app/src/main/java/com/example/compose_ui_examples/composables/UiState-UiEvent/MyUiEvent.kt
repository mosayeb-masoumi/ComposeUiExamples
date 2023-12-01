package com.example.compose_ui_examples.composables.`UiState-UiEvent`

sealed class MyUiEvent(){

    sealed class MyResult(val data: String) :MyUiEvent()
    object ButtonClicked: MyUiEvent()
}
