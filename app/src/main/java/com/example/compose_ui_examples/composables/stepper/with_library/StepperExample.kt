package com.example.compose_ui_examples.composables.stepper.with_library

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
//import com.binayshaw7777.kotstep.components.HorizontalIconStep
//import com.binayshaw7777.kotstep.ui.horizontal.HorizontalIconStepper
//import com.binayshaw7777.kotstep.ui.vertical.VerticalIconStepper
import com.google.accompanist.insets.statusBarsHeight
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun StepperExample() {

    // source : https://github.com/binayshaw7777/KotStep

    var currentStep by remember {
        mutableStateOf(0)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(top = 20.dp)
    ) {

//        Column {
//            HorizontalIconStepper(
//                totalSteps = 5,
//                currentStep = currentStep,
//                stepIconsList = listOf(
//                    Icons.Default.AccountBox,
//                    Icons.Default.AddCircle,
//                    Icons.Default.Build,
//                    Icons.Default.Face,
//                    Icons.Default.Home
//                ),
//
//                checkMarkColor = Color.Red,
//                stepSize = 36.dp,
//                lineThickness = 5.dp,
//                showCheckMarkOnDone = true,
//                stepDescription = listOf(
//                    "Step 1",
//                    "Step 2",
//                    "Step 3",
//                    "Step 4",
//                    "Step 5",
//                )
//            )
//
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 20.dp , vertical = 20.dp),
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//
//                Button(onClick = {
//                    if (currentStep >= 1) {
//                        currentStep--
//                    }
//                }) {
//                    Text(text = "Prev", color = Color.White)
//                }
//
//                Button(onClick = {
//                    if (currentStep <= 5) {
//                        currentStep++
//                    }
//                }) {
//                    Text(text = "Next", color = Color.White)
//                }
//            }
//
//
//            VerticalIconStepper(
//                totalSteps = 5,
//                currentStep = currentStep,
//                stepIconsList = listOf(
//                    Icons.Default.AccountBox,
//                    Icons.Default.AddCircle,
//                    Icons.Default.Build,
//                    Icons.Default.Face,
//                    Icons.Default.Home
//                ),
//
//                checkMarkColor = Color.Red,
//                stepSize = 36.dp,
//                lineThickness = 5.dp,
//                showCheckMarkOnDone = true,
//                stepDescription = listOf(
//                    "Step 1",
//                    "Step 2",
//                    "Step 3",
//                    "Step 4",
//                    "Step 5",
//                )
//            )
//
//        }

    }
}