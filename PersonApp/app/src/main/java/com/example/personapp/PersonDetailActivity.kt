package com.example.personapp

import android.app.Application
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.personapp.entity.Person
import com.example.personapp.viewmodel.DetailPageViewModel
import com.example.personapp.viewmodel.MainPageViewModel
import com.example.personapp.viewmodelfactory.DetailPageViewModelFactory
import com.example.personapp.viewmodelfactory.MainPageViewModelFactory

@Composable
fun PersonDetail(personData: Person) {
    val tfPersonName = remember { mutableStateOf("") }
    val tfPersonNumber = remember { mutableStateOf("") }
    val context = LocalContext.current
    val viewModel : DetailPageViewModel = viewModel(
        factory = DetailPageViewModelFactory(context.applicationContext as Application)
    )
    val localFocusManager = LocalFocusManager.current

    LaunchedEffect(key1 = true) {
            tfPersonName.value = personData.personName
            tfPersonNumber.value=personData.personNumber
    }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Person Detail") })
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
                    viewModel.update(personData.personId,personName,personNumber)
                    localFocusManager.clearFocus()
                }, modifier = Modifier.size(250.dp, 50.dp)) {
                    Text(text = "Update")
                }
            }
        })
    )
}
