package com.example.compose_ui_examples.composables.Chips

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ElevatedSuggestionChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ChipsScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .wrapContentHeight()
            .padding(all = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AssistChipSample()
        ElevatedAssistChipSample()
        FilterChipSample()
        InputChipSample()
        SuggestChipSample()
        ElevatedSuggestChipSample()
        ChipsGrpSingleLine()
        Divider()
        ChipsWithFlowRowSample()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AssistChipSample() {

    AssistChip(onClick = { }, label = { Text(text = "Assist Chip") },
        leadingIcon = { Icon(imageVector = Icons.Filled.Home, contentDescription = null) })

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ElevatedAssistChipSample() {

    ElevatedAssistChip(onClick = { }, label = { Text(text = "Assist Chip") },
        leadingIcon = { Icon(imageVector = Icons.Filled.Home, contentDescription = null) })

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChipSample() {
    var selected by remember { mutableStateOf(false) }

    ElevatedFilterChip(
        selected = selected,
        onClick = {
            selected = !selected
        },
        label = { Text(text = "FilterChips") },
        leadingIcon = {
            Icon(
                imageVector = if (selected) Icons.Filled.Home else Icons.Filled.Settings,
                contentDescription = null
            )
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputChipSample() {
    var selected by remember { mutableStateOf(false) }
    InputChip(
        selected = selected,
        onClick = { selected = !selected },
        label = { Text(text = "InputChip") },
        avatar = {
            Icon(
                imageVector = Icons.Filled.Info,
                contentDescription = "",
                modifier = Modifier.size(InputChipDefaults.AvatarSize)
            )
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuggestChipSample() {
    SuggestionChip(onClick = { /*TODO*/ }, label = { Text(text = "SuggestionChip") })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ElevatedSuggestChipSample() {
    ElevatedSuggestionChip(onClick = { /*TODO*/ },
        label = { Text(text = "ElevatedSuggestionChip") })
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChipsGrpSingleLine() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            repeat(9) { index ->
                AssistChip(
                    onClick = { /*TODO*/ },
                    label = { Text(text = "Chip $index") },
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ChipsWithFlowRowSample() {
    Column {
        FlowRow(
            modifier = Modifier
                .fillMaxWidth(1f)
                .wrapContentHeight(align = Alignment.Top),
//            maxItemsInEachRow = 5 // optional , or it automatically get the fillMaxWidth
        ) {
            repeat(10) { index ->

                AssistChip(
                    onClick = { /*TODO*/ },
                    label = { Text(text = "FlowRow $index") },
                    modifier = Modifier
                        .padding(horizontal = 4.dp , vertical = 2.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }
}


@Preview
@Composable
fun ChipsScreenPreview() {
    ChipsScreen()
}
