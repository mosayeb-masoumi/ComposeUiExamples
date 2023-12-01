package com.example.compose_ui_examples.composables.KEYBOAED_box

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_ui_examples.composables.KEYBOAED_box.components.HorizontalDivider
import com.example.compose_ui_examples.composables.KEYBOAED_box.components.RowWithThreeItems

@Composable
fun BoxKeyboard() {


    var number by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green.copy(alpha = 0.5f)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = number,
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .width(300.dp)
                .height(400.dp)
                .shadow(elevation = 10.dp, shape = RoundedCornerShape(20.dp))
                .background(color = Color.White)
        ) {


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)

            ) {
                RowWithThreeItems(
                    DividerPlace.TOP,
                    "7",
                    "8",
                    "9"
                ) {
                    number += it
                }
            }

            HorizontalDivider()

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)

            ) {
                RowWithThreeItems(
                    DividerPlace.MIDDLE,
                    "4",
                    "5",
                    "6"
                ) {
                    number += it
                }
            }

            HorizontalDivider()

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {

                RowWithThreeItems(
                    DividerPlace.MIDDLE,
                    "1",
                    "2",
                    "3"
                ) {
                    number += it
                }
            }

            HorizontalDivider()

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)

            ) {

                RowWithThreeItems(
                    DividerPlace.BOTTOM,
                    "Clear",
                    "0",
                    "Back"
                ) {

                    when (it) {
                        "0" -> number += it
                        "Clear" -> number = ""
                        "Back" -> {
                            if (number.isNotEmpty())
                                number = number.substring(0, number.length - 1)
                        }
                    }

                }
            }
        }


    }
}



@Preview
@Composable
fun BoxKeyboardPreview() {
    BoxKeyboard()
}