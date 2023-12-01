package com.example.compose_ui_examples.composables.Buttons

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Message
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext

@Composable
fun IconButtonsScreen(){
    val contextForToast = LocalContext.current.applicationContext
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
       
        IconButton(onClick = {
            Toast.makeText(contextForToast ,"Icon Button",Toast.LENGTH_LONG).show()
        })
        {
            Icon(imageVector = Icons.Default.Email , contentDescription = "Email" )
        }

        FilledIconButton(
            onClick = {
                Toast.makeText(contextForToast, "Filled Icon Button", Toast.LENGTH_SHORT).show()
            }
        ) {
            Icon(imageVector = Icons.Default.Email, contentDescription = "Email")
        }

        FilledTonalIconButton(
            onClick = {
                Toast.makeText(contextForToast, "Filled Tonal Icon Button", Toast.LENGTH_SHORT).show()
            }
        ) {
            Icon(imageVector = Icons.Default.Email, contentDescription = "Email")
        }

        OutlinedIconButton(
            onClick = {
                Toast.makeText(contextForToast, "Outlined Icon Button", Toast.LENGTH_SHORT).show()
            }
        ) {
            Icon(imageVector = Icons.Default.Email, contentDescription = "Email")
        }
    }
}