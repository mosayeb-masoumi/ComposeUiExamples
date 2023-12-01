package com.example.compose_ui_examples.composables.search_in_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//import com.example.compose_ui_examples.ui.theme.compose_ui_examplesTheme

@Composable
fun SearchScreen() {

    var searchText by remember { mutableStateOf("") }


    val filteredNames = if (searchText.isEmpty()) {
        nameList
    } else {
        nameList.filter { it.contains(searchText, ignoreCase = true) }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = searchText,
                onValueChange = {
                    searchText = it
                },
                textStyle = TextStyle(color = Color.Black),
                label = { Text(text = "Search") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .clip(RoundedCornerShape(0.dp))
            )

            Spacer(modifier = Modifier.height(10.dp))

            LazyColumn(contentPadding = PaddingValues(5.dp)) {

                itemsIndexed(filteredNames) { index, item ->
                    MyItem(index, item)
                }

            }

        }
    }
}

@Composable
fun MyItem(index: Int, item: String) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 5.dp)
            .height(100.dp)
            .padding(horizontal = 15.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(color = Color.Blue.copy(alpha = 0.4f))
            .padding(horizontal = 20.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(text = item, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}

val nameList = mutableListOf<String>(
    "ali",
    "reza",
    "hassan",
    "mona",
    "milad",
    "nabi"
)

@Preview(showBackground = true, widthDp = 380, heightDp = 1000)
@Composable
fun SearchScreenPreview() {
        SearchScreen()
}