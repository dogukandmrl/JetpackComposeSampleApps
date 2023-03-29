package com.example.myfoodapplication

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailPage(food: Foods) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Foods") },
                backgroundColor = colorResource(id = R.color.main_color),
                contentColor = Color.White
            )
        },
        content = ({
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val activity = (LocalContext.current as Activity)
                Image(
                    bitmap = ImageBitmap.imageResource(
                        id = activity.resources.getIdentifier(
                            food.foodImageName, "drawable", activity.packageName
                        )
                    ), contentDescription = "", modifier = Modifier.size(250.dp)
                )
                Text(text = "${food.foodPrice} ₺", color = Color.Blue, fontSize = 50.sp)
                Button(
                    onClick = { Log.e("Detail", "Food Clicked") },
                    modifier = Modifier.size(250.dp, 50.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.main_color),
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Order")
                }
            }
        })
    )
}