package com.example.compose_ui_examples.composables.flow_samples

sealed class FlowUIEvent {

    object MutableStateOfClicked: FlowUIEvent()
    object MutableStateFlowClicked: FlowUIEvent()
    object MutableSharedFlowClicked: FlowUIEvent()
}
