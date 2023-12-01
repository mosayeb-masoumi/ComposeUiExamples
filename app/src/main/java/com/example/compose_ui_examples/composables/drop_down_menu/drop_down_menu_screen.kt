package com.example.compose_ui_examples.composables.drop_down_menu

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.IconToggleButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun DropDownMenuScreen() {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(text = "Example 1")
        Spacer(modifier = Modifier.height(10.dp))
        DropDownExample1()
        Spacer(modifier = Modifier.height(50.dp))

        Text(text = "Example 2")
        DropDownExample2()

    }

}

@Composable
fun DropDownExample1() {
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("Item 1", "Item 2", "Item 3")
    var selectedItem by remember { mutableStateOf(items[0]) }

    Box(
        modifier = Modifier
            .width(200.dp)

    ) {

        IconButton(onClick = {
            expanded = !expanded
        }) {
            Icon(Icons.Default.MoreVert, contentDescription = null)
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(200.dp)
        ) {
            items.forEach { item ->
                DropdownMenuItem(onClick = {
                    selectedItem = item
                    expanded = false
                }) {
                    Text(text = item, color = Color.Black)
                }
            }
        }
    }
}

@Composable
fun DropDownExample2() {

    var expanded by remember { mutableStateOf(false) }
    val items = listOf("Item 1", "Item 2", "Item 3")
    var selectedItem by remember { mutableStateOf(items[0]) }

    val rotationState by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f,
        animationSpec = tween(durationMillis = 300)
    )


    Box(modifier = Modifier.width(200.dp)) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = selectedItem, modifier = Modifier.weight(1f))
//            IconButton(onClick = { expanded = !expanded }) {
//                if(expanded){
//                    Icon(Icons.Default.ArrowDropUp, contentDescription = "ArrowDown")
//                }else{
//                    Icon(Icons.Default.ArrowDropDown, contentDescription = "ArrowDown")
//                }
//            }

            // ArrowDropDown icon (down arrow) that expands the dropdown menu
            IconToggleButton(
                checked = expanded,
                onCheckedChange = { expanded = it },
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Icon(
                    Icons.Default.ArrowDropDown,
                    contentDescription = "Expand menu",
                    modifier = Modifier.rotate(rotationState)
                )
            }

        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(200.dp)
        ) {

            items.forEach { item ->
                DropdownMenuItem(onClick = {
                    selectedItem = item
                    expanded = false
                }) {
                  Text(text = item , color = Color.Red)
                }
            }

        }

    }
}

@Preview
@Composable
fun GreetingPreview() {
    DropDownMenuScreen()
}