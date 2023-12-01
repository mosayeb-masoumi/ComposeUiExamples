package com.example.compose_ui_examples.composables.Buttons

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.FilledTonalIconToggleButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.IconToggleButtonColors
import androidx.compose.material3.OutlinedIconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

@Composable
fun IconToggleButtons() {
    val contextForToast = LocalContext.current.applicationContext

    var checked1 by remember { mutableStateOf(true) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        IconToggleButton(
            checked = checked1,
            onCheckedChange = { boolState ->
                checked1 = boolState
                Toast.makeText(contextForToast, "Icon Toggle Button $checked1", Toast.LENGTH_SHORT)
                    .show()

            },


            colors = IconToggleButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Red,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = Color.Transparent,
                checkedContainerColor = Color.Transparent,
                checkedContentColor = Color.Transparent,
            )

        ) {
            Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite Item")
        }



        var checked2 by remember {
            mutableStateOf(true)
        }

        FilledIconToggleButton(
            checked = checked2,
            onCheckedChange = { _checked2 ->
                checked2 = _checked2
                Toast.makeText(
                    contextForToast,
                    "Filled Icon Toggle Button $checked2",
                    Toast.LENGTH_SHORT
                ).show()
            }
        ) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favorite Item"
            )
        }


        var checked3 by remember {
            mutableStateOf(true)
        }
        FilledTonalIconToggleButton(
            checked = checked3,
            onCheckedChange = { _checked3 ->
                checked3 = _checked3
                Toast.makeText(
                    contextForToast,
                    "Filled Tonal Icon Toggle Button $checked3",
                    Toast.LENGTH_SHORT
                ).show()
            }
        ) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favorite Item"
            )
        }


        var checked4 by remember {
            mutableStateOf(true)
        }
        OutlinedIconToggleButton(
            checked = checked4,
            onCheckedChange = { _checked4 ->
                checked4 = _checked4
                Toast.makeText(
                    contextForToast,
                    "Outlined Icon Toggle Button $checked4",
                    Toast.LENGTH_SHORT
                ).show()
            }
        ) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favorite Item"
            )
        }

    }
}