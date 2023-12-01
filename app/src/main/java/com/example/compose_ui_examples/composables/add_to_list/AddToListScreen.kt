package com.example.compose_ui_examples.composables.add_to_list

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//import com.example.compose_ui_examples.ui.theme.compose_ui_examplesTheme


@Composable
fun AddToListScreen() {

//    val user = User(1)
//    val users =  remember { mutableStateListOf(user) }
    val users = remember { mutableStateListOf<User>() }


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = {
            users.add(User(1))
        }) {
            Text(text = "Add tolistr")
        }

        UserList(users)
    }
}

@Composable
fun UserList(users: SnapshotStateList<User>) {

    LazyColumn(contentPadding = PaddingValues(all = 10.dp)) {

        itemsIndexed(users) { item, index ->
            myBox(item)
        }
    }
}


@Composable
fun myBox(item: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(all = 8.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(color = Color.Green.copy(alpha = 0.4f))
            .border(width = 1.dp, color = Color.Black, RoundedCornerShape(20.dp))
            .padding(horizontal = 10.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(text = "$item")
    }
}

@Preview(showBackground = true)
@Composable
fun AddToListScreenPreview() {
        myBox(1)
}

data class User(
    val id: Int
)