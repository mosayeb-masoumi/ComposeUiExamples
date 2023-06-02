package com.example.composeuiexamples.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeuiexamples.Destination
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch



@OptIn(ExperimentalPagerApi::class)
@Composable
fun ViewPagerTabBar() {
    val tabData = listOf(
        "MUSIC" to Icons.Filled.Home,
        "MARKET" to Icons.Filled.ShoppingCart,
        "FILMS" to Icons.Filled.AccountBox,
        "BOOKS" to Icons.Filled.Settings,
    )
    val pagerState = rememberPagerState(
        pageCount = tabData.size,
        initialOffscreenLimit = 3,
        infiniteLoop = true,
        initialPage = 0,
    )
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()
    Column {
        TabRow(
            selectedTabIndex = tabIndex,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
                )
            }
        ) {
            tabData.forEachIndexed { index, pair ->
                Tab(selected = tabIndex == index, onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }, text = {
                    Text(text = pair.first)
                }, icon = {
                    Icon(imageVector = pair.second, contentDescription = null)
//                     Icon(imageVector = Icons.Default.Home, contentDescription = null)
                })
            }
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { index ->
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = tabData[index].first,
                )
            }
        }
    }
}








//enum class TabPage(val icon: ImageVector, val title: String) {
//
//    Home(Icons.Default.Home, "Home"),
//    Setting(Icons.Default.Settings, "Setting")
//}
//
//@Composable
//fun TabHome(selectedIndex: Int, onSelect: (TabPage) -> Unit) {
//
//    TabRow(
//        selectedTabIndex = selectedIndex,
//        contentColor = Color.Yellow,
//        backgroundColor = Color.LightGray
//    ) {
//        TabPage.values().forEachIndexed { index, tabPage ->
//
//            Tab(
//                index == selectedIndex, {
//                    onSelect(tabPage)
//                },
//                text = { Text(text = tabPage.title) },
//                icon = { Icon(imageVector = tabPage.icon, contentDescription = null) },
//                selectedContentColor = Color.Green,
//                unselectedContentColor = Color.Red
//            )
//        }
//    }
//}
//
//@OptIn(ExperimentalPagerApi::class)
//@Composable
//fun ViewPagerTabBar() {
//    val pagerSelect = rememberPagerState(pageCount = TabPage.values().size)
//    val scope = rememberCoroutineScope()
//
//    Column(modifier = Modifier.fillMaxSize()) {
//
//        // tab bar
//        Box(
//            modifier = Modifier
//                .fillMaxWidth(),
//            //                .height(100.dp)
//        ) {
//
//            TabHome(selectedIndex = pagerSelect.currentPage, onSelect = {
//                scope.launch {
////                    pagerSelect.animateScrollToPage(it.ordinal)
//                    pagerSelect.animateScrollToPage(it.ordinal)
//                }
//            })
//        }
//
//        Box(
//            modifier = Modifier
//                .fillMaxSize(),
//        ) {
//            HorizontalPager(state = pagerSelect) { index ->
//                Column(modifier = Modifier.fillMaxSize()) {
//                    when (index) {
//                        0 -> {
//                            Box(modifier = Modifier.fillMaxSize() , contentAlignment = Alignment.Center) {
//                                Text(text = "Page 1", fontSize = 30.sp)
//                            }
//
//                        }
//                        1 -> {
//                            Box(modifier = Modifier.fillMaxSize() , contentAlignment = Alignment.Center) {
//                                Text(text = "Page 2", fontSize = 30.sp)
//                            }
//                        }
//                    }
//                }
//            }
//
//
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(bottom = 30.dp),
//                verticalArrangement = Arrangement.Bottom,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                HorizontalPagerIndicator(
//                    pagerState = pagerSelect,
//                    activeColor = Color.Red,
//                    inactiveColor = Color.Blue
//                )
//            }
//        }
//    }
//}