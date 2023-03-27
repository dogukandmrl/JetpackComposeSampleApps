package com.example.logindesignapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.logindesignapp.ui.theme.LoginDesignAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginDesignAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginPage()
                }
            }
        }
    }
}

@Composable
fun LoginPage() {
    Surface(color = MaterialTheme.colors.primary) {

        val tfNickname = remember { mutableStateOf("") }
        val tfPassword = remember { mutableStateOf("") }


        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "")
            TextField(
                value = tfNickname.value,
                onValueChange = { tfNickname.value = it },
                label = { Text(text = "Nickname") },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    textColor = Color.Black,
                    focusedIndicatorColor = Color.Red
                )
            )
            TextField(
                value = tfPassword.value,
                onValueChange = { tfPassword.value = it },
                label = { Text(text = "Password") },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    textColor = Color.Black,
                    focusedIndicatorColor = Color.Red
                )
            )
            Button(
                onClick = { Log.e("Button", "Logged") },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Red,
                    contentColor = Color.White
                ), modifier = Modifier.size(250.dp, 50.dp)
            ) {
                Text(text = "Login")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginDesignAppTheme {

        LoginPage()
    }
}