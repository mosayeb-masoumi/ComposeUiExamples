package com.example.compose_ui_examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_ui_examples.ui.theme.TextColor
import com.example.compose_ui_examples.ui.theme.BgColor
import com.example.compose_ui_examples.ui.theme.Primary
import com.example.compose_ui_examples.ui.theme.Secondary


@Composable
fun NormalTextComponent(value: String) {

    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp), style = TextStyle(
            fontWeight = FontWeight.Normal, fontStyle = FontStyle.Normal
        ),
        color = TextColor,
        textAlign = TextAlign.Center
    )

}


@Composable
fun ButtonComponent(
    value: String,
    onButtonClicked: () -> Unit,
    isEnabled: Boolean = true,
    isLoading: Boolean = false
) {

    Button(
        onClick = {
            onButtonClicked.invoke()
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(20.dp)),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        enabled = isEnabled
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(Secondary, Primary)),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            if (isLoading)
                CircularProgressIndicator(color = Color.White)
            else
                Text(text = value, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}


@Composable
fun TextFieldComponent(
    label: String,
    leadingIcon: ImageVector,
    onTextSelected: (String) -> Unit,
    errorStatus: Boolean = true

) {

    val value = remember { mutableStateOf("") }
    OutlinedTextField(

        value = value.value,
        onValueChange = {
            value.value = it
            onTextSelected(it)
        },

        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp)),

        shape = RoundedCornerShape(20.dp),
        label = { Text(text = label) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
            backgroundColor = BgColor
        ),

        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        singleLine = true,
        maxLines = 1,
        leadingIcon = { Icon(leadingIcon, contentDescription = "") },
        isError = errorStatus


    )
}