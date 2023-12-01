package com.example.compose_ui_examples.composables.nice_ui_1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_ui_examples.R
import com.example.compose_ui_examples.ui.theme.purplish

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NiceUi_1() {


    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by rememberSaveable() { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.top_background),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(200.dp)
                .height(150.dp)
        )

        Text(
            text = "Welcome to my nice ui",
            fontSize = 28.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            color = purplish
        )



        TextField(
            value = userName,
            onValueChange = {
                userName = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(66.dp)
                .padding(start = 64.dp, end = 64.dp, top = 8.dp, bottom = 8.dp)
                .border(width = 1.dp, color = purplish, shape = RoundedCornerShape(50.dp)),

            shape = RoundedCornerShape(50.dp),
//            placeHolder =
//                Text(
//                    modifier = Modifier.fillMaxWidth(),
//                    text = "usename", textAlign = TextAlign.Center
//                ),
//            label = {
//                Text(
//                    modifier = Modifier.fillMaxWidth(),
//                    text = "usename", textAlign = TextAlign.Center
//                )
//            },



            textStyle = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                color = purplish
            ),
            placeholder = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "usename", textAlign = TextAlign.Center
                )
            },
            colors = TextFieldDefaults.textFieldColors(
//                containerColor = Color.Transparent ,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,

                )
        )


        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(66.dp)
                .padding(start = 64.dp, end = 64.dp, top = 8.dp, bottom = 8.dp)
                .border(width = 1.dp, color = purplish, shape = RoundedCornerShape(50.dp)),

            shape = RoundedCornerShape(50.dp),
            textStyle = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                color = purplish
            ),
            placeholder = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "password", textAlign = TextAlign.Center
                )
            },
//            label = {
//                Text(
//                    modifier = Modifier.fillMaxWidth(),
//                    text = "password", textAlign = TextAlign.Center
//                )
//            },
            colors = TextFieldDefaults.textFieldColors(
//                containerColor = Color.Transparent ,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )


        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(66.dp)
                .padding(start = 64.dp, end = 64.dp, top = 8.dp, bottom = 8.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = purplish,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(50.dp)
        )
        {
            Text(text = "Login", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }


        Text(
            text = "dont rememeber password? click here",
            fontSize = 14.sp,
            color = purplish, modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "",
                Modifier.padding(8.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.twitter),
                contentDescription = "",
                Modifier.padding(8.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = "",
                Modifier.padding(8.dp)
            )
        }

        Spacer(Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.bottom_background),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )


    }
}

@Preview
@Composable
fun NiceUi_1Preview() {
    NiceUi_1()
}