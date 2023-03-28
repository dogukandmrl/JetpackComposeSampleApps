package com.example.numberpredictionapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.random.Random

@Composable
fun PredictPage(navController: NavController) {
    val tfGuess = remember { mutableStateOf("") }
    val randomNumber = remember { mutableStateOf(0) }
    val guessRemaining = remember { mutableStateOf(5) }
    val help = remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LaunchedEffect(key1 = true) {
            randomNumber.value = Random.nextInt(101)
        }
        Text(text = "Guess Remaining: ${guessRemaining.value}", fontSize = 36.sp, color = Color.Red)
        Text(text = "Help : ${help.value}", fontSize = 24.sp)

        TextField(
            value = tfGuess.value,
            onValueChange = { tfGuess.value = it },
            label = { Text(text = "Guess") }
        )
        Button(
            onClick = {
                guessRemaining.value = guessRemaining.value-1
                val guess = tfGuess.value.toInt()

                if (guess == randomNumber.value) {
                    navController.navigate("resultpage/true") {
                        popUpTo("predictpage") { inclusive = true }
                    }
                    return@Button
                }
                if (guess > randomNumber.value) {
                    help.value="Decrease"
                }
                if (guess < randomNumber.value) {
                    help.value="Increase"
                }
                if (guessRemaining.value == 0) {
                    navController.navigate("resultpage/false") {
                        popUpTo("predictpage") { inclusive = true }
                    }
                }
                tfGuess.value=""
            },
            modifier = Modifier.size(250.dp, 50.dp)
        ) {
            Text(text = "Guess")
        }
    }
}