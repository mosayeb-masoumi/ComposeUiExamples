package com.example.compose_ui_examples.composables.snack_bar_material3

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@Composable
fun SnackBarM3() {
    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackBarHostState) }
    ) { padding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {

            Button(onClick = {
                scope.launch {
                   val result = snackBarHostState.showSnackbar(
                        message = "this is snackBar",
                        actionLabel = "Retry" , // when use actionLabel , snackbar shouldnt disappear until we click on button
                        withDismissAction = true,
                        duration = SnackbarDuration.Short
                    )
                     when(result){
                         SnackbarResult.Dismissed -> {
                             var a = 5
                         }
                         SnackbarResult.ActionPerformed -> {
                             var a =5
                         }
                     }
                }

            }) {
                Text(text = "SnackBar Material3")
            }

        }
    }
}