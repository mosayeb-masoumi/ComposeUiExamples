package com.example.compose_ui_examples.composables

//import androidx.compose.foundation.Icon
import androidx.compose.foundation.Image
//import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
//import androidx.compose.ui.text.annotatedString
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp



import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.navigation.NavHostController
import com.example.compose_ui_examples.Destination
import com.example.compose_ui_examples.R
import com.example.compose_ui_examples.ui.theme.Shapes
import com.example.compose_ui_examples.ui.theme.orangish
import com.example.compose_ui_examples.ui.theme.purplish


//@Preview(showBackground = true)
@Composable
fun LoginPage1(navController: NavHostController) {

    Box {
        bgCard()
        MainCard(navController)
    }
}

@Composable
fun bgCard() {

    val signUpText = buildAnnotatedString {
        append("Don,t have an account? ")
        withStyle(SpanStyle(color = orangish)) {
            append("Sign up here!")
        }
    }


    Surface(color = purplish, modifier = Modifier.fillMaxSize()) {

        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(bottom = 30.dp)
        ) {

            Row() {
                Image(painter = painterResource(id = R.drawable.ic_fb), contentDescription = "")
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Image(painter = painterResource(id = R.drawable.ic_google), contentDescription = "")
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_twitter),
                    contentDescription = ""
                )
            }

            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            Text(text = signUpText, style = TextStyle(color = Color.White))
        }
    }
}

@Composable
fun MainCard(navController: NavHostController) {

    val emailstate = remember { mutableStateOf(TextFieldValue("Enter valid Email")) }
    val passState = remember { mutableStateOf(TextFieldValue("Enter password")) }

    Surface(
        color = Color.White, modifier = Modifier
            .height(600.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)

            Image(painter = painterResource(id = R.drawable.ic_vaccum), contentDescription = "")
            Spacer(modifier = Modifier.padding(16.dp))

            OutlinedTextField(
                value = emailstate.value,
                onValueChange = {
                    emailstate.value = it
                },
                leadingIcon = {
                    Icon(
                        contentDescription = null,
                        imageVector = Icons.Default.Email
                    )
                },
                modifier = modifier
            )

            Spacer(modifier = Modifier.padding(6.dp))

            OutlinedTextField(
                value = passState.value,
                onValueChange = {
                    passState.value = it
                },
                leadingIcon = {
                    Icon(
                        contentDescription = null,
                        imageVector = Icons.Default.Lock
                    )
                },
                modifier = modifier, keyboardActions = KeyboardActions.Default
            )

            Spacer(modifier = Modifier.padding(vertical = 12.dp))


            Text(
                text = "Forget Pssword?", textAlign = TextAlign.End,
                modifier = modifier
            )

            Spacer(modifier = Modifier.padding(vertical = 16.dp))

            Button(
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    backgroundColor = orangish
                ),

                onClick = {
                    navController.navigate(Destination.OnBoarding.createRoute(15, 25))
                },
                modifier = modifier,
                shape = Shapes.medium,
                contentPadding = PaddingValues(16.dp)
            ) {
                Text(text = "Log in")
            }
//
        }
    }
}