package com.example.compose_ui_examples.composables.KEYBOAED_box

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.compose_ui_examples.composables.KEYBOAED_box.components.HorizontalDivider
import com.example.compose_ui_examples.composables.KEYBOAED_box.components.RowWithThreeItems

@Composable
fun keyboard3in3() {

    Column(
        modifier = Modifier
            .width(300.dp)
            .height(300.dp)
            .shadow(elevation = 10.dp, shape = RoundedCornerShape(20.dp))
            .background(color = Color.White)
    ) {


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)

        ) {
            RowWithThreeItems(DividerPlace.TOP, "7", "8", "9"){

            }
        }

        HorizontalDivider()

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)

        ) {
            RowWithThreeItems(DividerPlace.MIDDLE, "4", "5", "6"){}
        }

        HorizontalDivider()

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)

        ) {

            RowWithThreeItems(DividerPlace.BOTTOM, "1", "2", "3"){}
        }
    }
}