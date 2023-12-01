package com.example.compose_ui_examples.composables.SaveStateHandlerExample.SaveStateHandleObjectSerializable

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose_ui_examples.composables.login_register.components.ButtonComponent
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking

@SuppressLint("UnrememberedMutableState")
@Composable
fun SaveStateHandleSerializableScreen(myViewModel: SerializableViewModel = viewModel()) {


    var getSavedData by remember { mutableStateOf(myViewModel.getSavedData) }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(all = 16.dp)
    ) {


        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(50.dp))
            ButtonComponent(
                value = "saveData",
                onButtonClicked = {

                    val data = MySerializableDataClass("hassan", 11)
                    myViewModel.saveData(data)
                    getSavedData = myViewModel.getSavedData

                    runBlocking {
                        myViewModel.getValues().collect{
                            Log.i("TAGGgg", "$it")
                        }
                    }


                }
            )

            Spacer(modifier = Modifier.height(20.dp))


            getSavedData?.let {
                Text(text = "${it.name} ${it.age}", modifier = Modifier.padding(16.dp))
            }
        }

    }
}