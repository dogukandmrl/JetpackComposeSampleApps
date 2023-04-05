package com.example.personapp

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.personapp.entity.Person
import com.example.personapp.ui.theme.PersonAppTheme
import com.example.personapp.viewmodel.MainPageViewModel
import com.example.personapp.viewmodelfactory.MainPageViewModelFactory
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PersonAppTheme {
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
    PersonAppTheme {

    }
}

@Composable
fun PageChanger() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mainPage") {
        composable("mainPage") {
            MainPage(navController = navController)
        }
        composable("personRegisterPage") {
            PersonRegister()
        }
        composable("personDetailPage/{person}", arguments = listOf(
            navArgument("person") {
                type = NavType.StringType
            }
        )) {
            val json = it.arguments?.getString("person")
            val obj = Gson().fromJson(json, Person::class.java)
            PersonDetail(obj)
        }
    }
}

@Composable
fun MainPage(navController: NavController) {
    val isSearch = remember { mutableStateOf(false) }
    val tf = remember { mutableStateOf("") }
    val context = LocalContext.current
    val viewModel : MainPageViewModel= viewModel(
        factory = MainPageViewModelFactory(context.applicationContext as Application)
    )
    val personList = viewModel.personList.observeAsState(listOf())
    LaunchedEffect(key1 = true){
        viewModel.setContact()
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if (isSearch.value) {
                        TextField(
                            value = tf.value,
                            onValueChange = {
                                tf.value = it
                                viewModel.search(it)
                            },
                            label = {
                                Text(
                                    text = "Search"
                                )
                            },
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.Transparent,
                                focusedLabelColor = Color.White,
                                focusedIndicatorColor = Color.White,
                                unfocusedIndicatorColor = Color.White,
                                unfocusedLabelColor = Color.White
                            )
                        )
                    } else
                        Text(text = "Person App")

                },
                actions = {
                    if (isSearch.value) {
                        IconButton(onClick = {
                            isSearch.value = false
                            tf.value = ""
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.close_art),
                                contentDescription = "",
                                tint = Color.White
                            )
                        }
                    } else {
                        IconButton(onClick = { isSearch.value = true }) {
                            Icon(
                                painter = painterResource(id = R.drawable.search_art),
                                contentDescription = "",
                                tint = Color.White
                            )
                        }
                    }

                }
            )
        },
        content = ({
            LazyColumn {
                items(
                    count = personList.value!!.count(),
                    itemContent = {
                        val person = personList.value!![it]
                        Card(
                            modifier = Modifier
                                .padding(all = 5.dp)
                                .fillMaxWidth()
                        ) {
                            Row(modifier = Modifier.clickable {
                                val personJson = Gson().toJson(person)
                                navController.navigate("personDetailPage/${personJson}")
                            }) {
                                Row(
                                    modifier = Modifier
                                        .padding(all = 10.dp)
                                        .fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(text = "${person.personName}-${person.personNumber}")
                                    IconButton(onClick = {
                                        viewModel.delete(person.personId)
                                    }) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.delete_art),
                                            contentDescription = "",
                                            tint = Color.Gray
                                        )
                                    }

                                }
                            }
                        }
                    }
                )
            }
        }),
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("personRegisterPage") },
                backgroundColor = colorResource(id = R.color.teal_200),
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.add_art),
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            )


        }
    )


}

