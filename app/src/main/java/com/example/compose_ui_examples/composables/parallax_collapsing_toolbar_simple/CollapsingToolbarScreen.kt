package com.example.compose_ui_examples.composables.parallax_collapsing_toolbar_simple

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CollapsingToolbarScreen(){

    CollapsingTopAppBarNoStylingScreen()
//    CollapsingTopAppBarScreen()
//    SingleItemCollapsingTopAppBarScreen()
//     PinnedTopAppBarScreen()



}


@Preview
@Composable
fun CollapsingToolbarScreenPreview(){
    CollapsingToolbarScreen()
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CollapsingTopAppBarNoStylingScreen(modifier: Modifier = Modifier){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
     val items = listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20
         ,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)

    Scaffold (
        topBar = {

            LargeTopAppBar(

                title = { Text(text = "enterAlways") },
                navigationIcon = { IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.ArrowBack, contentDescription ="" )
                }},
                actions = { IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.Info, contentDescription ="" )
                }},
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    scrolledContainerColor = MaterialTheme.colorScheme.primary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor= MaterialTheme.colorScheme.onPrimary,
                ),
                scrollBehavior = scrollBehavior
            )

        },
                modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    )
    {
       LazyColumn(modifier = Modifier
           .fillMaxWidth()
           .padding(it),

       ){

           itemsIndexed(items) { index, item ->
               Text(
                   text = "Index: $index, Item: $item",
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(8.dp)
               )
           }

//           items(items){ item ->
//               Text(
//                   text = "item $item",
//                   modifier = Modifier.padding(10.dp)
//               )
//           }
       }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CollapsingTopAppBarScreen(modifier: Modifier = Modifier){


    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    val isCollapsed = remember { derivedStateOf { scrollBehavior.state.collapsedFraction > 0.5 } }

    val topAppBarElementColor = if (isCollapsed.value) {
        MaterialTheme.colorScheme.onSurface
    } else {
        MaterialTheme.colorScheme.onPrimary
    }
    val collapsedTextSize = 22
    val expandedTextSize = 28

    val topAppBarTextSize = (collapsedTextSize + (expandedTextSize - collapsedTextSize)*(1-scrollBehavior.state.collapsedFraction))

    val items = (1..40).toList()

    Scaffold (
        topBar = {
            LargeTopAppBar(
                title = { Text(text = "title", fontSize = topAppBarTextSize.sp) },
                navigationIcon = { IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.ArrowBack, contentDescription ="" )
                }},
                actions = { IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.Info, contentDescription ="" )
                }},
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    scrolledContainerColor = MaterialTheme.colorScheme.surface,
                    navigationIconContentColor = topAppBarElementColor,
                    titleContentColor = topAppBarElementColor,
                    actionIconContentColor= topAppBarElementColor,
                ),
                scrollBehavior = scrollBehavior
            )
        },
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    )
    {
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .padding(it),
        ){

            itemsIndexed(items) { index, item ->
                Text(
                    text = "Index: $index, Item: $item",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
        }
    }
}





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingleItemCollapsingTopAppBarScreen(modifier: Modifier = Modifier) {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    val isCollapsed = remember { derivedStateOf { scrollBehavior.state.collapsedFraction > 0.5 } }

    val topAppBarElementColor = if (isCollapsed.value) {
        MaterialTheme.colorScheme.onSurface
    } else {
        MaterialTheme.colorScheme.onPrimary
    }
    val collapsedTextSize = 22
    val expandedTextSize = 28

    val topAppBarTextSize = (collapsedTextSize + (expandedTextSize - collapsedTextSize)*(1-scrollBehavior.state.collapsedFraction)).sp



    Scaffold(
        topBar = {
            LargeTopAppBar(
                title = { Text("single item", fontSize = topAppBarTextSize) },
                navigationIcon = { IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.ArrowBack, contentDescription ="" )
                }},
                actions = { IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.Info, contentDescription ="" )
                }},
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    scrolledContainerColor = MaterialTheme.colorScheme.surface,
                    navigationIconContentColor = topAppBarElementColor,
                    titleContentColor = topAppBarElementColor,
                    actionIconContentColor= topAppBarElementColor,
                ),
                scrollBehavior = scrollBehavior
            )
        },
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { innerPadding ->
        Box(contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                Text("string.empty_list_text")
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PinnedTopAppBarScreen(modifier: Modifier = Modifier) {

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())


    val isScrolled = remember { derivedStateOf { scrollBehavior.state.contentOffset < -100f } }

    val topAppBarElementColor = if (isScrolled.value) {
        MaterialTheme.colorScheme.onSurface
    } else {
        MaterialTheme.colorScheme.onPrimary
    }

    val topAppBarContainerColor = if (isScrolled.value) {
        MaterialTheme.colorScheme.surface
    } else {
        MaterialTheme.colorScheme.primary
    }


    val items = listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20
        ,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)

    Scaffold(
        topBar = {
            LargeTopAppBar(
                title = { Text("PinnedTopAppBarScreen") },
                navigationIcon = { IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.ArrowBack, contentDescription ="" )
                }},
                actions = { IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.Info, contentDescription ="" )
                }},
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = topAppBarContainerColor,
                    scrolledContainerColor = MaterialTheme.colorScheme.surface, // Ignored
                    navigationIconContentColor = topAppBarElementColor,
                    titleContentColor = topAppBarElementColor,
                    actionIconContentColor= topAppBarElementColor,
                ),
                scrollBehavior = scrollBehavior
            )
        },
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) {
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .padding(it)){

            itemsIndexed(items) { index, item ->
                Text(
                    text = "Index: $index, Item: $item",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }

//           items(items){ item ->
//               Text(
//                   text = "item $item",
//                   modifier = Modifier.padding(10.dp)
//               )
//           }
        }
    }
}









