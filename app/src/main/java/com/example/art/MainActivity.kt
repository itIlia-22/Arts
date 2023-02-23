package com.example.art

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.art.ui.theme.ArtTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtCard()
                }
            }
        }
    }
}

@Composable
fun ArtCard() {
    var state by remember {
        mutableStateOf(1)
    }

    when (state) {
        1 -> ImageAndTextAndButtonArt(
            artImage = R.drawable.liza,
            artText = R.string.mona_liza,
            onClickNext = { state = 2 },
            onClickDone = {
                if (state <= 1) {
                    state = 1
                }
            })
        2 -> ImageAndTextAndButtonArt(
            artImage = R.drawable.mehski,
            artText = R.string.misha,
            onClickNext = { state = 3 },
            onClickDone = { state = 1 })
        3 -> ImageAndTextAndButtonArt(
            artImage = R.drawable.pol,
            artText = R.string.yl,
            onClickNext = { state = 4 },
            onClickDone = { state = 2 })
        4 -> ImageAndTextAndButtonArt(
            artImage = R.drawable.vangog,
            artText = R.string.van_gog,
            onClickNext = { state = 5 },
            onClickDone = { state = 3 })
        5 -> ImageAndTextAndButtonArt(
            artImage = R.drawable.vrema,
            artText = R.string.time,
            onClickNext = {
                if (state == 5) {
                    state = 1
                }

            },
            onClickDone = { state = 4 })
    }
}

@Composable
fun ImageAndTextAndButtonArt(
    artImage: Int,
    artText: Int,
    onClickNext: () -> Unit,
    onClickDone: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(modifier = Modifier.padding(24.dp, 24.dp, 24.dp, 24.dp)) {
            Image(
                painter = painterResource(artImage), contentDescription = null,
                modifier = modifier.padding(top = 8.dp)
            )

        }
        Spacer(modifier = Modifier.padding(16.dp))
        Column(

            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(artText),
                color = Color.Gray,
                fontSize = 24.sp,
            )
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Box(
            modifier = modifier
                .fillMaxSize()
            //.padding(bottom = 450.dp)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(start = 80.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                TextButton(onClick = onClickDone) {
                    Text(
                        text = stringResource(R.string.back),
                        fontSize = 16.sp, color = Color.Black,
                        fontFamily = FontFamily.SansSerif
                    )


                }
            }
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(end = 80.dp),
                horizontalArrangement = Arrangement.End
            ) {
                TextButton(
                    onClick = onClickNext
                ) {
                    Text(
                        text = stringResource(R.string.go),
                        fontSize = 16.sp, color = Color.Black,
                        fontFamily = FontFamily.SansSerif
                    )


                }
            }


        }


    }


}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtTheme {
        ArtCard()
    }
}