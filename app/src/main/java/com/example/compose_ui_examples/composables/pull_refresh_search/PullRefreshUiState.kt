package com.example.compose_ui_examples.composables.pull_refresh_search

import com.example.compose_ui_examples.composables.pull_refresh_search.components.RefreshModel

data class PullRefreshUiState(
    val isRefreshing: Boolean = false,
    val refreshList: List<RefreshModel> = listOf()
)
