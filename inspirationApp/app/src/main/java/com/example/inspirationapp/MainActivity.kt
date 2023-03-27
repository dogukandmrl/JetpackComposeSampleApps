package com.example.inspirationapp

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.inspirationapp.ui.theme.InspirationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InspirationAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FirstPage()
                }
            }
        }
    }
}

@Composable
fun FirstPage() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Inspiration App") },
                backgroundColor = colorResource(id = R.color.mainColor),
                contentColor = colorResource(id = R.color.white)
            )
        },
        content = ({
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.stevejobs),
                        contentDescription = ""
                    )
                    Text(
                        text = "Steve Jobs",
                        color = androidx.compose.ui.graphics.Color.Red,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                }
                Text(
                    text = "You can’t connect the dots looking forward; you can only connect them looking backwards. So you have to trust that the dots will somehow connect in your future.",
                    modifier = Modifier.padding(all = 10.dp),
                    textAlign = TextAlign.Center
                )

                Button(
                    onClick =
                    { Log.e("Button", "Inspiration Given") },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = androidx.compose.ui.graphics.Color.Red,
                        contentColor = androidx.compose.ui.graphics.Color.White
                    )
                ) {
                    Text(text = "Inspiration")
                }
            }
        })
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InspirationAppTheme {
        FirstPage()
    }
}