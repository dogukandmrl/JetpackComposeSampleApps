package com.example.myfoodapplication

import android.app.Activity
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
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
import com.example.myfoodapplication.ui.theme.MyFoodApplicationTheme
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFoodApplicationTheme {
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
    MyFoodApplicationTheme {

    }
}
@Composable
fun PageChanger(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mainpage"){
        composable("mainpage"){
            MainPage(navController = navController)
        }
        composable("detailpage/{food}", arguments = listOf(
            navArgument("food"){type = NavType.StringType}
        )){
            val json = it.arguments?.getString("food")
            val food =Gson().fromJson(json,Foods::class.java)
            DetailPage(food = food)
        }
    }
}

@Composable
fun MainPage(navController: NavController) {
    val foodsList = remember { mutableListOf<Foods>() }
    LaunchedEffect(key1 = true) {
        val food1 = Foods(1, "Meatball", "meatball", 90)
        val food2 = Foods(2, "Ayran", "ayran", 15)
        val food3 = Foods(3, "Fanta", "fanta", 25)
        val food4 = Foods(4, "Spaghetti", "spaghetti", 75)
        val food5 = Foods(5, "Kadayif", "kadayif", 80)
        val food6 = Foods(6, "Baklava", "baklava", 100)

        foodsList.add(food1)
        foodsList.add(food2)
        foodsList.add(food3)
        foodsList.add(food4)
        foodsList.add(food5)
        foodsList.add(food6)

    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Foods") },
                backgroundColor = colorResource(id = R.color.main_color),
                contentColor = Color.White
            )
        },
        content = ({
            LazyColumn {
                items(
                    count = foodsList.count(),
                    itemContent = {
                        val food = foodsList[it]
                        Card(
                            modifier = Modifier
                                .padding(all = 5.dp)
                                .fillMaxWidth()
                        ) {
                            Row(modifier = Modifier.clickable {
                                val foodJson= Gson.toJson(food)
                                navController.navigate("detailpage/{food}")
                            }) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .padding(all = 10.dp)
                                        .fillMaxWidth()
                                ) {
                                    val activity = (LocalContext.current as Activity)
                                    Image(
                                        bitmap = ImageBitmap.imageResource(
                                            id = activity.resources.getIdentifier(
                                                food.foodImageName, "drawable", activity.packageName
                                            )
                                        ), contentDescription = "", modifier = Modifier.size(100.dp)
                                    )
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Column(
                                            verticalArrangement = Arrangement.SpaceEvenly,
                                            modifier = Modifier.fillParentMaxHeight()
                                        ) {
                                            Text(text = food.foodName, fontSize = 10.sp)
                                            Spacer(modifier = Modifier.size(30.dp))
                                            Text(text = "${food.foodPrice} ₺", color = Color.Blue)
                                        }
                                        Icon(
                                            painter = painterResource(id = R.drawable.arrow_art),
                                            contentDescription = ""
                                        )
                                    }
                                }
                            }

                        }
                    }
                )
            }


        })
    )
}

