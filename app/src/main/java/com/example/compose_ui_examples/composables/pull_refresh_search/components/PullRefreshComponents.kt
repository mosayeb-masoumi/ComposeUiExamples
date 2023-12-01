package com.example.compose_ui_examples.composables.pull_refresh_search.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_ui_examples.ui.theme.Primary

@Composable
fun PullRefreshTextField(
    labelValue: String,
    leadingImage: ImageVector = Icons.Default.Search,
    onTextChanged : (String) -> Unit
) {
    var value by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp)),
        value = value,
        onValueChange = {
            value = it
            onTextChanged.invoke(it)
        },


        shape = RoundedCornerShape(10.dp),
        label = { Text(text = labelValue)},
        colors = OutlinedTextFieldDefaults.colors(
            focusedLabelColor = Primary,
            cursorColor = Color.Black,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = Color.Blue,
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        singleLine = true,
        maxLines = 1,
        leadingIcon = { Icon(imageVector = leadingImage, contentDescription = "")}
    )
}

@Preview
@Composable
fun PullRefreshTextFieldPreview(){
    PullRefreshTextField(labelValue = "label", leadingImage = Icons.Default.Search , onTextChanged = {})
}
