package com.example.compose_ui_examples.composables.sharepreference

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun SharePreferenceScreen(){

    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    val dataStore = SharePreference(context = context)

    val savedEmail = dataStore.getEmail.collectAsState(initial = "")

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 100.dp) , horizontalAlignment = Alignment.CenterHorizontally) {

        Button(onClick = {
            scope.launch {
                dataStore.setEmail("mb.masoumi1000@gmail.com")
            }
        }) {
            Text("set gmail in sharePref and show")
        }
        
        Text(text = savedEmail.value!!)
    }
}