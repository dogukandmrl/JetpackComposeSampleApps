package com.example.personapp

import android.util.Log
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
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.personapp.viewmodel.PersonRegisterViewModel

@Composable
fun PersonRegister() {
    val tfPersonName = remember { mutableStateOf("") }
    val tfPersonNumber = remember { mutableStateOf("") }
    val localFocusManager = LocalFocusManager.current

    val viewModel:PersonRegisterViewModel= viewModel()
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Person Register") })
        },
        content = ({
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                TextField(
                    value = tfPersonName.value,
                    onValueChange = { tfPersonName.value = it },
                    label = {
                        Text(
                            text = "Person Name"
                        )
                    })
                TextField(
                    value = tfPersonNumber.value,
                    onValueChange = { tfPersonNumber.value = it },
                    label = {
                        Text(
                            text = "Person Tel No"
                        )
                    })
                Button(onClick = {
                    val personName = tfPersonName.value
                    val personNumber = tfPersonNumber.value
                    viewModel.register(personName,personNumber)
                    localFocusManager.clearFocus()
                }, modifier = Modifier.size(250.dp, 50.dp)) {
                    Text(text = "Save")
                }
            }
        })
    )
}