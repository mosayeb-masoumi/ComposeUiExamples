package com.example.compose_ui_examples.composables.Network_image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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


import com.google.accompanist.placeholder.material.shimmer
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder


@Composable
fun NetworkImageScreen() {

    val imageLink =
        "https://fastly.picsum.photos/id/866/536/354.jpg?hmac=tGofDTV7tl2rprappPzKFiZ9vDh5MKj39oa2D--gqhA"

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp),
        contentAlignment = Alignment.Center
    ) {


        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(50.dp))

            Text(text = "using material shimmer")

            // example 1
            Box(
                modifier = Modifier
                    .width(200.dp)
                    .padding(top = 50.dp)
                    .height(200.dp)
                    .clip(RoundedCornerShape(10.dp)),

                contentAlignment = Alignment.Center
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .placeholder(
                            visible = true,
                            color = Color.Gray,
                            // optional, defaults to RectangleShape
                            shape = RoundedCornerShape(4.dp),
                            highlight = PlaceholderHighlight.shimmer(
                            ),
                        )
                )



                Image(
                    painter = rememberImagePainter(
                        data = imageLink,

                        builder = {
//                            placeholder(R.drawable.ic_launcher_background)
                            error(R.drawable.ic_google)
                            diskCachePolicy(CachePolicy.ENABLED)
                        }
                    ),
                    contentDescription = "image from internet link",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop,

                    )
            }

            Spacer(modifier = Modifier.height(50.dp))

            Text(text = "using shimmer class")



            // example 2
            Box(
                modifier = Modifier
                    .width(200.dp)
                    .padding(top = 20.dp)
                    .height(200.dp)
                    .clip(shape = CircleShape),

                contentAlignment = Alignment.Center
            ) {


                ShimmerPlaceHolder(width = 200, height = 200)

                Image(
                    painter = rememberImagePainter(
                        data = imageLink,

                        builder = {
//                            placeholder(R.drawable.ic_launcher_background)
                            error(R.drawable.ic_google)
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

    }

}

@Preview
@Composable
fun GreetingPreview() {
    NetworkImageScreen()
}


