package com.example.compose_ui_examples.composables.AutoSlider


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.request.CachePolicy
import com.example.compose_ui_examples.R
import com.google.accompanist.pager.*

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AutoSliderScreen() {

    val pagerSelect = rememberPagerState(pageCount = sliderDataList.size)
    val scope = rememberCoroutineScope()


    LaunchedEffect(pagerSelect.currentPage) {
        while (true) {
            delay(5000)
            scope.launch {
                pagerSelect.animateScrollToPage((pagerSelect.currentPage + 1) % sliderDataList.size)
            }
        }
    }




    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .height(300.dp)
        ) {

            SliderViewPager(pagerSelect)

            Box(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .align(Alignment.BottomCenter)
            ) {
                SliderPagerIndicator(pagerSelect, scope)
            }


        }

    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun SliderViewPager(pagerSelect: PagerState) {

    HorizontalPager(state = pagerSelect) { index ->
        ShowImage(index)
    }
}

@Composable
fun ShowImage(index: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(20.dp)),
        contentAlignment = Alignment.Center
    ) {

        ShimmerSliderPlaceHolder(height = 300)
        Image(
            painter = rememberImagePainter(
                data = sliderDataList[index].imgLink,
                builder = {
                    error(R.drawable.ic_launcher_background)
                    diskCachePolicy(CachePolicy.ENABLED)
                }
            ),
            contentDescription = "image from internet link",
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(20.dp)),
            contentScale = ContentScale.Crop)
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun SliderPagerIndicator(pagerSelect: PagerState, scope: CoroutineScope) {

    HorizontalPagerIndicator(
        pagerState = pagerSelect,
        activeColor = Color.Red,
        inactiveColor = Color.White,
    )
}


@Preview
@Composable
fun GreetingPreview() {
    AutoSliderScreen()
}


data class SliderData(
    val imgLink: String,
)

val sliderDataList = listOf(
    SliderData(
        "https://fastly.picsum.photos/id/1084/536/354.jpg?grayscale&hmac=Ux7nzg19e1q35mlUVZjhCLxqkR30cC-CarVg-nlIf60",
    ),
    SliderData(
        "https://fastly.picsum.photos/id/866/536/354.jpg?hmac=tGofDTV7tl2rprappPzKFiZ9vDh5MKj39oa2D--gqhA",

        ),
    SliderData(
        "https://fastly.picsum.photos/id/237/200/300.jpg?hmac=TmmQSbShHz9CdQm0NkEjx1Dyh_Y984R9LpNrpvH2D_U"
    )
)
