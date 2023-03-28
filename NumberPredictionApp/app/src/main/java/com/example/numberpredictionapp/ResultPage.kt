package com.example.numberpredictionapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResultPage(result:Boolean) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (result){
            Text(text = "You Win", fontSize = 36.sp)
            Image(
                painter = painterResource(id = R.drawable.good_mood_art),
                contentDescription = ""
            )
        }
       else{
            Text(text = "You Lose", fontSize = 36.sp)
            Image(
                painter = painterResource(id = R.drawable.bad_mood_art),
                contentDescription = ""
            )
        }
    }
}