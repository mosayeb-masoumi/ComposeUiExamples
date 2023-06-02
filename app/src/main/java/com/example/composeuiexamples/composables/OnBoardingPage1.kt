package com.example.composeuiexamples.composables

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingPage1(elementId: Int, age: Int) {


    val pagerSelect = rememberPagerState(pageCount = 3)
    val scope = rememberCoroutineScope()

    Box {

        MyViewPager(pagerSelect)
        MyViewPagerIndicator(pagerSelect, scope)


    }
}

@OptIn(ExperimentalPagerApi::class)
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
                    Text(text = "Screen 1" , color = Color.Black , fontSize = 25.sp , textAlign = TextAlign.Center)
                }
            }
            1 -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Red),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Screen 2" , color = Color.Black , fontSize = 25.sp , textAlign = TextAlign.Center)

                }
            }
            2 -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Yellow),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Screen 3" , color = Color.Black , fontSize = 25.sp , textAlign = TextAlign.Center)
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MyViewPagerIndicator(pagerSelect: PagerState, scope: CoroutineScope) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 30.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPagerIndicator(
            pagerState = pagerSelect,
            activeColor = Color.Black,
            inactiveColor = Color.White
        )
        
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {

            IconButton(onClick = {

                scope.launch {
                    pagerSelect.animateScrollToPage(2)
                }

            }) {
                Text(text = "    Skip" , fontSize = 25.sp , fontWeight = FontWeight.Bold)
            }
            
            IconButton(onClick = {
                if(pagerSelect.currentPage < 2){

                    scope.launch {
                       pagerSelect.animateScrollToPage(pagerSelect.currentPage + 1)
                    }

                }else{
                    Toast.makeText(context ,"Home Started" ,Toast.LENGTH_LONG).show()
                }

            }) {

                if(pagerSelect.currentPage == 2){
                    Text("GO Home  " , color = Color.Black , fontWeight = FontWeight.Bold , fontSize = 25.sp)
                }else{
                    Text("Next  " , color = Color.Black , fontWeight = FontWeight.Bold , fontSize = 25.sp)
                }
            }
        }
    }

}




