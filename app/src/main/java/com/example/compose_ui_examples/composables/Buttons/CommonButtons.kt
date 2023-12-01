package com.example.compose_ui_examples.composables.Buttons

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
//import androidx.compose.material.Button
//import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext

@Composable
fun CommonButtons() {
    val contextForToast = LocalContext.current.applicationContext
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            Toast.makeText(contextForToast, "Button", Toast.LENGTH_SHORT).show()
        })
        {
            Text(text = "Button")
        }

        ElevatedButton(onClick = {
            Toast.makeText(contextForToast, "Elevated Button", Toast.LENGTH_SHORT).show()
        })
        {
            Text(text = "Elevated Button")
        }

        FilledTonalButton(

            onClick = {
                Toast.makeText(contextForToast, "FilledTonalButton", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "FilledTonalButton")
        }

        OutlinedButton(
            onClick = {
                Toast.makeText(contextForToast, "OutlinedButton", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "OutlinedButton")
        }

        TextButton(
            onClick = {
                Toast.makeText(contextForToast, "TextButton", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "TextButton")
        }
    }
}