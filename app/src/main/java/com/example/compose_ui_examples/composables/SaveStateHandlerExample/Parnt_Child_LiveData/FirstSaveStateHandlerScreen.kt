package com.example.compose_ui_examples.composables.SaveStateHandlerExample.Parnt_Child_LiveData

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.compose_ui_examples.ButtonComponent
import com.example.compose_ui_examples.Destination
import com.example.compose_ui_examples.composables.login_register.components.NormalTextComponent

@Composable
fun FirstSaveStateHandlerScreen(navController: NavHostController) {


    val secondScreenResult = navController.currentBackStackEntry
        ?.savedStateHandle
//        ?.getLiveData<String>("count_key")?.observeAsState(initial = 0)
        ?.getStateFlow("countFromSecondScreen_key" , -1)?.collectAsState(initial = -1)


    var count by remember{ mutableStateOf(0) }


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp)
    ) {



        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Spacer(modifier = Modifier.height(20.dp))
            NormalTextComponent(value = "get result back from second page-----> ${secondScreenResult?.value}")



            Spacer(modifier = Modifier.height(10.dp))


            ButtonComponent(value = "increment", onButtonClicked = {
                count++
            })

            Spacer(modifier = Modifier.height(10.dp))

            ButtonComponent(value = "goto test b", onButtonClicked = {

                navController.currentBackStackEntry
                    ?.savedStateHandle
                    ?.set("countFromFirstScreen_key", count)
                navController.navigate(Destination.SecondSaveStateHandlerScreen.route)
            })

            NormalTextComponent(value = "get result back from second page-----> $count")
        }
    }
}

@Preview
@Composable
fun showPreview() {
    val context = LocalContext.current
    FirstSaveStateHandlerScreen(navController = NavHostController(context))

}