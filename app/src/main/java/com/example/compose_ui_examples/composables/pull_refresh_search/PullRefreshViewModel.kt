package com.example.compose_ui_examples.composables.pull_refresh_search

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose_ui_examples.composables.pull_refresh_search.components.RefreshModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PullRefreshViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PullRefreshUiState())
    val uiState = _uiState.asStateFlow()

    var items = mutableStateListOf<RefreshModel>()

    init {
        items.addAll(getInitList())
        _uiState.value = uiState.value.copy(
            refreshList = items
        )
    }


    fun onEvent(event: PullRefreshUiEvent) {
        when (event) {

            is PullRefreshUiEvent.IsPulled -> {
                doRefreshing()
            }

            is PullRefreshUiEvent.TextFieldChanged -> {
                val query = event.query
                doSearch(query)
            }
        }
    }

    private fun doRefreshing() {
        viewModelScope.launch {

            _uiState.value = uiState.value.copy(
                isRefreshing = true,
            )

            delay(2000)

            // add a new item
             items.add(RefreshModel("title ${items.size +1}"))

            _uiState.value = uiState.value.copy(
                isRefreshing = false,
                refreshList = items
            )
        }
    }

    private fun doSearch(query: String) {
        val filteredList = if (query.isEmpty()) {
            getInitList()
        } else {
            getInitList().filter { it.title.lowercase().contains(query, ignoreCase = true) }
        }

        _uiState.value = uiState.value.copy(
            refreshList = filteredList
        )
    }


    private fun getInitList(): List<RefreshModel> {
        return listOf(
            RefreshModel("Item"),
            RefreshModel("Item"),
            RefreshModel("yu"),
            RefreshModel("Item"),
            RefreshModel("Item")
        )
    }


}