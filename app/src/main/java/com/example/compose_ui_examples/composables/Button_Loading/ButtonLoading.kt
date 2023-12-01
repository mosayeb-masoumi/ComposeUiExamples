package com.example.compose_ui_examples.composables.Button_Loading

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose_ui_examples.ButtonComponent
import com.example.compose_ui_examples.NormalTextComponent
import com.example.compose_ui_examples.TextFieldComponent
import com.example.compose_ui_examples.R

@Composable
fun ButtonLoadingScreen(buttonLoadingViewModel: ButtonLoadingViewModel = viewModel()) {

    val textFieldValue = remember { mutableStateOf("") }

//    val result = homeViewModel.result.value
//    val isLoading = homeViewModel.isLoading.value

    val result = buttonLoadingViewModel.result.collectAsState()
    val isLoading = buttonLoadingViewModel.isLoading.collectAsState()



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(28.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {




        Spacer(modifier = Modifier.height(20.dp))
        TextFieldComponent(
            label = stringResource(R.string.add_name),
            leadingIcon = Icons.Default.Person,
            onTextSelected = {
                textFieldValue.value = it
            },

            errorStatus = textFieldValue.value.length <= 1
        )

        Spacer(modifier = Modifier.height(20.dp))
        ButtonComponent(
            value = stringResource(R.string.confirm),
            onButtonClicked = {
                buttonLoadingViewModel.sendDataToServer(textFieldValue.value)
//                isButtonLoading.value = true
            },
            isEnabled = textFieldValue.value.length > 1,
//            isLoading = isButtonLoading.value
//            isLoading = isButtonLoading
            isLoading = isLoading.value
        )



//        NormalTextComponent(value = result)
        NormalTextComponent(value = result.value)

    }
}