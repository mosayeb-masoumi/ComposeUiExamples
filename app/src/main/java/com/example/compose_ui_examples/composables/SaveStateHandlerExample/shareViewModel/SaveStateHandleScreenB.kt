package com.example.compose_ui_examples.composables.SaveStateHandlerExample.shareViewModel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun SaveStateHandleScreenB(navController: NavHostController ,shareViewModel: SharedViewModel) {

    val savedValue = shareViewModel.savedStateHandle.get<Int>("intValue") ?: -1


    Surface(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(16.dp)) {

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

            Text(text =  "$savedValue"  )
        }
    }
}
