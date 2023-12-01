package com.example.compose_ui_examples.composables.pull_refresh_search

sealed class PullRefreshUiEvent{
    data class TextFieldChanged(val query: String) :PullRefreshUiEvent()
    object IsPulled:PullRefreshUiEvent()
}
