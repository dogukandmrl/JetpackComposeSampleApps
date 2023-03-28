package com.example.numberpredictionapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.numberpredictionapp.ui.theme.NumberPredictionAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NumberPredictionAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PageChanger()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NumberPredictionAppTheme {

    }
}
@Composable
fun PageChanger(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mainpage"){
        composable("mainpage"){
            MainPage(navController = navController)
        }
        composable("predictpage"){
            PredictPage(navController = navController)
        }
        composable("resultpage/{result}", arguments = listOf(
            navArgument("result"){type = NavType.BoolType}
        )){
            val result = it.arguments?.getBoolean("result")!!
            ResultPage(result=result)
        }
    }
}

@Composable
fun MainPage(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Prediction Game", fontSize = 36.sp)
        Image(
            painter = painterResource(id = R.drawable.dice_art),
            contentDescription = ""
        )
        Button(
            onClick = {
                navController.navigate("predictpage")
            },
            modifier = Modifier.size(250.dp, 50.dp)
        ) {
            Text(text = "Let's Begin")
        }
    }
}

