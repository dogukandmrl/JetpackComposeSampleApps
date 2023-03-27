package com.example.foodbookappdesign

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodbookappdesign.ui.theme.FoodBookAppDesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodBookAppDesignTheme {
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
                title = { Text(text = "FoodBook App") },
                backgroundColor = colorResource(id = R.color.mainColor)
            )


        },
        content = ({
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(painter = painterResource(id = R.drawable.foodpic), contentDescription = "")
                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        onClick = { Log.e("Button", "Liked") },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.mainColor)
                        ),
                        modifier = Modifier.weight(50f)
                    ) {
                        Context(context = "Like")
                    }
                    Button(
                        onClick = { Log.e("Button", "Commented") },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.alternativeColor)
                        ),
                        modifier = Modifier.weight(50f)
                    ) {
                        Context(context = "Comment")
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 10.dp)
                ) {
                    Text(
                        text = "Meatball",
                        color = colorResource(id = R.color.alternativeColor),
                        fontSize = 18.sp
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Context(context = "Suitable for Grill ")
                        Context(context = "24 March")
                    }
                    Text(
                        text = "In a large bowl, combine the ground beef, onion, garlic, egg, breadcrumbs, cumin, paprika, salt, and black pepper. Mix well until all the ingredients are evenly distributed.\n" +
                                "Divide the mixture into equal portions and shape them into oval-shaped patties.\n" +
                                "Preheat the grill to medium-high heat. Grill the meatballs for about 4-5 minutes on each side or until they are fully cooked and slightly charred.",
                        modifier = Modifier
                            .padding(all = 10.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }

        })
    )
}

@Composable
fun Context(context: String) {
    Text(text = context)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FoodBookAppDesignTheme {
        FirstPage()
    }
}