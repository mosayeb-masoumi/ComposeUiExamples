package com.example.compose_ui_examples.composables.share_viewmodel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController


@Composable
fun DetailShareViewModelScreen(
    navController: NavHostController,
    myShareViewModel: MySharedViewModel
){

    val person= myShareViewModel.person

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "detail screen")

        person?.firstName?.let { Text(text = it) }
        person?.lastName?.let { Text(text = it) }
    }
}