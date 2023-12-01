package com.example.compose_ui_examples.composables.KEYBOAED_box.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.compose_ui_examples.composables.KEYBOAED_box.DividerPlace

@Composable
fun RowWithThreeItems(
    dividerPlace: DividerPlace,
    leftNumber: String,
    middleNumber: String,
    rightNumber: String,
    onClick: (String) -> Unit
) {
    Row(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .clickable {
                    onClick(leftNumber)
                },
            contentAlignment = Alignment.Center
        ) {
            Text(text = leftNumber, fontSize = 16.sp)
        }

        when (dividerPlace) {
            DividerPlace.TOP -> TopFadeDivider()
            DividerPlace.MIDDLE -> MiddleDivider()
            else -> BottomFadeDivider()
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .clickable {
                    onClick(middleNumber)
                },
            contentAlignment = Alignment.Center
        ) {
            Text(text = middleNumber, fontSize = 16.sp)
        }

        when (dividerPlace) {
            DividerPlace.TOP -> TopFadeDivider()
            DividerPlace.MIDDLE -> MiddleDivider()
            else -> BottomFadeDivider()
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .clickable {
                    onClick(rightNumber)
                },
            contentAlignment = Alignment.Center
        ) {
            Text(text = rightNumber, fontSize = 16.sp)
        }
    }
}