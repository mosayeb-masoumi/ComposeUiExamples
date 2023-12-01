package com.example.compose_ui_examples.composables.login_video_bg

import android.media.AudioFocusRequest
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.compose_ui_examples.R
import com.example.compose_ui_examples.ui.theme.Shapes
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsWithImePadding

@Composable
fun LoginVideoBgScreen() {

    val passwordFocusRequester = FocusRequester()
    val focusManager: FocusManager = LocalFocusManager.current

    ProvideWindowInsets {  // to prevent keyboard cover the textField

        Column(
            modifier = Modifier
                .navigationBarsWithImePadding()  // to prevent keyboard cover the textField
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.Bottom)
        ) {

            Icon(
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = null,
                Modifier.size(80.dp),
                tint = Color.White
            )

            TextInput(inputType = InputType.Name, keyboardActions = KeyboardActions(onNext = {
                passwordFocusRequester.requestFocus()
            }))

            TextInput(inputType = InputType.Password, keyboardActions = KeyboardActions(onDone = {
                focusManager.clearFocus()
            }), focusRequester = passwordFocusRequester)

            Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Sign In", Modifier.padding(all = 8.dp))
            }

            Divider(
                color = Color.White.copy(alpha = 0.3f),
                thickness = 1.dp,
                modifier = Modifier.padding(top = 48.dp)
            )

            Row(verticalAlignment = Alignment.CenterVertically) {

                Text(text = "Don't have an account?", color = Color.Black)
                TextButton(onClick = {

                }) {
                    Text(text = "Sign Up")
                }
            }
        }
    }
}


sealed class InputType(
    val label: String,
    val icon: ImageVector,
    val keyboardOptions: KeyboardOptions,
    val visualTransformation: VisualTransformation
) {
    object Name : InputType(
        label = "User Name",
        icon = Icons.Default.Person,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )

    object Password : InputType(
        label = "Password",
        icon = Icons.Default.Lock,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = PasswordVisualTransformation()
    )
}

@Composable
fun TextInput(inputType: InputType , focusRequester: FocusRequester?= null ,keyboardActions: KeyboardActions) {

    val value = remember {
        mutableStateOf("")
    }

    TextField(
        value = value.value,
        onValueChange = {
            value.value = it
        },
        modifier = Modifier.fillMaxWidth().focusOrder(focusRequester?: FocusRequester()),
        leadingIcon = { Icon(imageVector = inputType.icon, null) },
        label = {Text(text = inputType.label)},
        shape = Shapes.small,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Gray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        singleLine = true,
        keyboardOptions = inputType.keyboardOptions,
        visualTransformation = inputType.visualTransformation,
        keyboardActions = keyboardActions
    )
}