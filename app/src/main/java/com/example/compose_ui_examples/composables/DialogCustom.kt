package com.example.compose_ui_examples.composables

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.material.Icon
import androidx.compose.ui.platform.LocalContext


@Composable
fun DialogCustom() {

    val context = LocalContext.current
    val showDialog = remember { mutableStateOf(false) }

    if(showDialog.value)
        MyDialog(value = "", setShowDialog = {
            showDialog.value = it
        }) { backedResult ->
            Log.i("HomePage","HomePage : $backedResult ")
            val txtGotFromDialog = backedResult
            Toast.makeText(context , backedResult  , Toast.LENGTH_LONG).show()
        }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Yellow),
        contentAlignment = Alignment.Center
    ) {


        Button(onClick = {
            showDialog.value = true
        }) {
            Text(text = "Show Dialog")
        }
    }
}


@Composable
fun MyDialog(value: String, setShowDialog: (Boolean) -> Unit, onEventCallback: (String) -> Unit) {

    val txtFieldError = remember { mutableStateOf("") }
    val txtFiled = remember { mutableStateOf(value) }

    Dialog(onDismissRequest = { setShowDialog(false) }) {

        Surface(modifier = Modifier.padding(horizontal = 30.dp), shape = RoundedCornerShape(16.dp), color = Color.White) {

            Box(
                contentAlignment = Alignment.Center) {

                Column(modifier = Modifier.padding(20.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "My Custom Dialog",
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Icon(imageVector = Icons.Default.Cancel, contentDescription = null,
                            modifier = Modifier
                                .size(30.dp)
                                .clickable {
                                    setShowDialog(false)  // close the dialog
                                })

                    }

                    Spacer(Modifier.height(20.dp))

                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(

                                BorderStroke(
                                    width = 2.dp,
                                    color = colorResource(
                                        id = if (txtFieldError.value.isEmpty())
                                            android.R.color.holo_green_light else android.R.color.holo_red_light
                                    )
                                ),
                                shape = RoundedCornerShape(16.dp),
                            ),


                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Transparent,
                            focusedIndicatorColor = Color.Blue,
                            unfocusedIndicatorColor = Color.Green
                        ),

                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Cancel, contentDescription = null,
                                modifier = Modifier
                                    .size(30.dp)
                                    .clickable {
//                                        setShowDialog(false)
                                        txtFiled.value = ""
                                    })
                        },


                        placeholder = { Text(text = "Enter value") },

                        value = txtFiled.value,
                        onValueChange = {
                            txtFiled.value = it
                        })

                    Spacer(modifier = Modifier.height(20.dp))



                    Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                        Button(
                            onClick = {
                                if (txtFiled.value.isEmpty()) {
                                    txtFieldError.value = "Field can not be empty"
                                    return@Button
                                }
                                onEventCallback(txtFiled.value)
                                setShowDialog(false)    // close dialog
                            },
                            shape = RoundedCornerShape(50.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        ) {
                            Text(text = "Done")
                        }
                    }
                }
            }
        }
    }
}