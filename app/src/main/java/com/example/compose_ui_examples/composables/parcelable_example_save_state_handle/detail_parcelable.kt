package com.example.compose_ui_examples.composables.parcelable_example_save_state_handle

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun DetailParcelableScreen(navController: NavHostController) {




    // we used LaunchedEffect recomposition just once (we moved this block of code to destination
//    LaunchedEffect(key1 = "person"){
        val result = navController.previousBackStackEntry?.savedStateHandle?.get<PersonParcelableModel>(key = "person")
        Log.d("ParcelableDetail" , "${result?.firstName}")
        Log.d("ParcelableDetail" , "${result?.lastName}")
//    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "detail screen")
        result?.firstName?.let { Text(text = it) }
        result?.lastName?.let { Text(text = it) }
    }
}