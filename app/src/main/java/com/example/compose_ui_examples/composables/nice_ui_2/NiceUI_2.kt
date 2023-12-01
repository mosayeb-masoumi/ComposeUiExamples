package com.example.compose_ui_examples.composables.nice_ui_2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_ui_examples.R

@Composable
fun NiceUI_2() {

    val genres = listOf("BrainStorm", "Books", "Video", "Others")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(color = Color.White)
            .padding(all = 16.dp)
    )
    {
        Text(
            text = buildAnnotatedString {
                append("Choose what \n")
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                ) {
                    append("to learn today?")
                }
            },
            fontSize = 30.sp, modifier = Modifier.padding(bottom = 20.dp)
        )

        LazyRow(
            modifier = Modifier.padding(bottom = 25.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {

            items(genres) { genre ->

                Genre(genre)
            }
        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 10.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(color = Color.Blue.copy(alpha = 0.5f))
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {

                Column(modifier = Modifier.padding(20.dp)) {

                    Text(
                        text = "Vocabulary",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.size(10.dp))

                    Text(
                        text = "Listen to 20 new Words",
                        color = Color.White,
                        fontSize = 20.sp,
                    )

                    Spacer(modifier = Modifier.size(40.dp))

                    Button(
                        onClick = {},
                        modifier = Modifier
                            .height(60.dp)
                            .width(120.dp)
                            .clip(RoundedCornerShape(10.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White
                        )
                    ) {

                        Text(text = "Start", fontSize = 18.sp, color = Color.Black)
                        Spacer(modifier = Modifier.width(5.dp))
                        Box(
                            modifier = Modifier
                                .size(25.dp)
                                .clip(shape = CircleShape)
                                .background(color = Color.Black),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Filled.PlayArrow,
                                tint = Color.White,
                                contentDescription = null,
                                modifier = Modifier.padding(all = 2.dp)
                            )
                        }
                    }

                }

                Image(
                    painter = painterResource(id = R.drawable.brainy), contentDescription = "",
                    modifier = Modifier.weight(1f, fill = false)
                )

            }
        }


        Text(
            text = "Recommended",
            color = Color.Black,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(all = 10.dp)
        )

        LazyColumn(
            modifier = Modifier.padding(all = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            items(3) {
                Recommended()
            }
        }

    }
}

@Composable
fun Recommended() {

    var starSelected by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Color.Red.copy(alpha = 0.5f)),
        contentAlignment = Alignment.Center
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.Green.copy(alpha = 0.5f)),
                contentAlignment = Alignment.Center
            )
            {

                Icon(
                    imageVector = Icons.Filled.Email, contentDescription = "",
                    tint = Color.White, modifier = Modifier
                        .size(30.dp)
                        .padding(3.dp)
                )
            }

            Spacer(modifier = Modifier.width(10.dp))
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Chatting",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "5 minutes",
                    color = Color.Gray,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal
                )
            }

            Box(
                modifier = Modifier
                    .size(40.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription ="",
                    tint = if(starSelected) Color.Black else Color.Black.copy(alpha = 0.2f),

                    modifier = Modifier.clickable{
                        starSelected = !starSelected
                    }
                )
            }

        }
    }
}

@Composable
fun Genre(genre: String) {
    var isSelected by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .background(if (isSelected) Color.Black else Color.LightGray)
            .clickable {
                isSelected = !isSelected
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = genre,
            color = if (isSelected) Color.White else Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(all = 10.dp)
        )
    }
}


@Preview
@Composable
fun NiceUI_2Preview() {

    NiceUI_2()
}