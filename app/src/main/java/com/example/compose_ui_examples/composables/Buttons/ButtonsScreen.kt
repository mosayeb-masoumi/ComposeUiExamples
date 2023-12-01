package com.example.compose_ui_examples.composables.Buttons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ButtonsScreen(){

    Box(
        modifier = Modifier.fillMaxSize() ,
        contentAlignment = Alignment.Center)
    {

//        CommonButtons()
//        IconButtonsScreen()
          IconToggleButtons()
    }
}