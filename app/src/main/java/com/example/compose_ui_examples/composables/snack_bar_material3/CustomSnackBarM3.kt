package com.example.compose_ui_examples.composables.snack_bar_material3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Snackbar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_ui_examples.R
import kotlinx.coroutines.launch

@Composable
fun CustomSnackBarM3() {

    val context = LocalContext.current
    val snackBarState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Surface(color = Color.DarkGray, modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize()) {

            Button(
                modifier = Modifier.align(Alignment.Center),
                onClick = {

                    coroutineScope.launch {
                        snackBarState.showSnackbar(
                            message = "", // custom snackBar we don't need message
                            actionLabel = ""  // add this line , cause snackbar not disappear automatically
                        )
                    }

                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Black,
                    containerColor = Color.White
                )

            ) {
                Text(text = "Show custom SnackBar", fontSize = 16.sp)
            }

            SnackbarHost(
                modifier = Modifier.padding(bottom = 50.dp).align(Alignment.BottomCenter),
                hostState = snackBarState
            ) {
                //custom SnackBar

                CustomSnackBar(
                    title = "this is titlr",
                    content = "this is content",
                    onAction = {
                        var a = 5;
                    }
                )
//                CustomSnackBar()
            }
        }
    }
}


@Composable
fun CustomSnackBar(
    modifier: Modifier = Modifier,
    title: String,
    content: String,
    onAction: () -> Unit
) {

    Snackbar(
        elevation = 0.dp,
        backgroundColor = Color.Transparent
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {

            Column(
                modifier = Modifier
                    .padding(all = 16.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color(color = android.graphics.Color.parseColor("#00CEFF")),
                                Color(color = android.graphics.Color.parseColor("#FB9C88")),
                            )

                        )
                    )
                    .padding(start = 78.dp, top = 8.dp, bottom = 12.dp, end = 8.dp),
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    text = title,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.padding(vertical = 4.dp))

                Text(
                    text = content,
                    color = Color.White,
                    fontStyle = FontStyle.Italic,
                    fontSize = 20.sp
                )
            }


            Column(
                modifier = modifier
                    .padding(start = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Card(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.brainy),
                        contentScale = ContentScale.Crop,
                        contentDescription = "",
                        modifier = modifier.size(50.dp)
                    )

                    Spacer(modifier = Modifier.padding(vertical = 6.dp))

                    Image(
                        painter = painterResource(id = R.drawable.facebook),
                        contentScale = ContentScale.Fit,
                        contentDescription = "",
                        modifier = modifier
                            .size(30.dp)
                            .clickable {
                                onAction.invoke()
                            }
                    )
                }
            }
        }
    }

}

