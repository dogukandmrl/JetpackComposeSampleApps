package com.example.graduationprojectapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.graduationprojectapp.login.LoginViewModel
import com.example.graduationprojectapp.ui.theme.GraduationProjectAppTheme
import com.example.graduationprojectapp.ui.theme.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val loginViewModel = viewModel(
                modelClass = LoginViewModel::class.java
            )
            GraduationProjectAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    Navigation(loginViewModel = loginViewModel)
                        
                   }
                }
            }
        }
    }

