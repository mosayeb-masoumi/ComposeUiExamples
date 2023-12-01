package com.example.compose_ui_examples.composables.onboarding

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(elementId: Int, age: Int) {


    val pagerSelect = rememberPagerState(initialPage = 0, pageCount = { 3 })
    val scope = rememberCoroutineScope()

    Box {

        MyViewPager(pagerSelect)
        MyViewPagerIndicator(pagerSelect, scope)


    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyViewPager(pagerSelect: PagerState) {

    HorizontalPager(state = pagerSelect) { index ->
        when (index) {
            0 -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Green),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Screen 1",
                        color = Color.Black,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }

            1 -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Red),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Screen 2",
                        color = Color.Black,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center
                    )

                }
            }

            2 -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Yellow),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Screen 3",
                        color = Color.Black,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyViewPagerIndicator(pagerState: PagerState, scope: CoroutineScope) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 30.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PageIndicator(
            modifier = Modifier.width(100.dp),
            pageSize = 3,
            selectedPage = pagerState.currentPage
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            TextButton(onClick = {
                scope.launch {
                    pagerState.animateScrollToPage(2)
                }

            }) {
                Text(text = "Skip", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }

            TextButton(
                modifier = Modifier.wrapContentWidth(),
                onClick = {
                    if (pagerState.currentPage < 2) {

                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }

                    } else {
                        Toast.makeText(context, "Home Started", Toast.LENGTH_LONG).show()
                    }

                }) {

                if (pagerState.currentPage == 2) {
                    Text(
                        "GO Home",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                } else {
                    Text(
                        "Next",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }

}

@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    pageSize: Int,
    selectedPage: Int,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unSelectedColor: Color = Color.Blue
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.Center) {
        repeat(pageSize) { page ->
            Box(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .size(14.dp)
                    .clip(CircleShape)
                    .background(color = if (page == selectedPage) selectedColor else unSelectedColor)
            )
        }
    }
}


@Preview
@Composable
fun OnBoardingScreenPreview() {
    OnBoardingScreen(0 ?: 0, 10)
}