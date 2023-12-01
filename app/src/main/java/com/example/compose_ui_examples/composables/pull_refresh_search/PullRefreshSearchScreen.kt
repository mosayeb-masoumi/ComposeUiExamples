package com.example.compose_ui_examples.composables.pull_refresh_search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose_ui_examples.composables.pull_refresh_search.components.PullRefreshTextField
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun PullRefreshSearchScreen(
    refreshViewModel: PullRefreshViewModel = viewModel()
) {

    val uiState by refreshViewModel.uiState.collectAsState()

    val swipeRefresh = rememberSwipeRefreshState(isRefreshing = uiState.isRefreshing)


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(color = Color.White)
    ) {

        SwipeRefresh(
            state = swipeRefresh,
            onRefresh = {
                refreshViewModel.onEvent(PullRefreshUiEvent.IsPulled)
            },
            // customization
            indicator = {state , refreshTrigger ->
                SwipeRefreshIndicator(
                    state =state,
                    refreshTriggerDistance = refreshTrigger,
                    backgroundColor = Color.Red,
                    contentColor = Color.Yellow
                )
            }
        )
        {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp)
                    .background(color = Color.White)
            ) {

                PullRefreshTextField(
                    labelValue = "search",
                    onTextChanged = { query ->
                        refreshViewModel.onEvent(PullRefreshUiEvent.TextFieldChanged(query))
                    })

                Spacer(modifier = Modifier.height(10.dp))


                LazyColumn {
                    items(uiState.refreshList) { item ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .padding(bottom = 5.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(color = Color.Green.copy(alpha = 0.5f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = item.title, fontSize = 17.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }


            }
        }


    }

}

@Preview
@Composable
fun PullRefreshSearchScreenPreview() {
    PullRefreshSearchScreen()
}


