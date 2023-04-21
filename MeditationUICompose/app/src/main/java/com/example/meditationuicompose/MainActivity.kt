package com.example.meditationuicompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import com.example.meditationuicompose.ui.theme.HomeScreen
import com.example.meditationuicompose.ui.theme.MedidationUIComposeTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MedidationUIComposeTheme {
             HomeScreen()
            }
        }
    }
}
