package com.example.materialdesign

import android.media.midi.MidiOutputPort
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
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
import com.example.materialdesign.ui.theme.DetailPage
import com.example.materialdesign.ui.theme.MaterialDesignTheme
import kotlin.math.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialDesignTheme {
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
    MaterialDesignTheme {
        PageChanger()
    }
}
@Composable
fun PageChanger(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "page"){
        composable("page"){
            PageLazyColumnList(navController = navController)
        }
        composable("detailPage/{countryName}", arguments = listOf(
            navArgument("countryName"){
                type = NavType.StringType
            }
        )){
            val countryName = it.arguments?.getString("countryName")!!
            DetailPage(countryName = countryName)
        }

    }
}

@Composable
fun PageLazyColumnList(navController: NavController) {
    val countryList = remember { mutableListOf("Turkey", "Italy", "Germany", "Japan") }
    LazyColumn {
        items(
            count = countryList.count(),
            itemContent = {
                val country = countryList[it]
                Card(
                    modifier = Modifier
                        .padding(all = 5.dp)
                        .fillMaxWidth()
                ) {
                    Row(modifier = Modifier.clickable {
                        Log.e("List", "${country} Selected")
                        navController.navigate("detailPage/$country")
                    }) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(all = 10.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = country, modifier = Modifier
                                .padding(all = 5.dp)
                                .clickable {
                                    Log.e("List", "${country} Selected With Text")
                                })
                            OutlinedButton(onClick = {
                                Log.e("List", "${country} Selected With Button")
                            }) {
                                Text(text = "Select a Country")
                            }
                        }
                    }
                }
            }
        )
    }
}

@Composable
fun PageLazyRow() {
    LazyRow {
        item {
            Card(
                modifier = Modifier
                    .padding(all = 5.dp)
                    .size(100.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable { Log.e("List", "Sun Clicked") }) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(all = 10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.sun_art_24),
                            contentDescription = ""
                        )
                        Text(text = "Sun", modifier = Modifier.padding(all = 5.dp))
                    }
                }
            }
        }
        item {
            Card(
                modifier = Modifier
                    .padding(all = 5.dp)
                    .size(100.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable { Log.e("List", "Moon Clicked") }) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(all = 10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.moon_art),
                            contentDescription = ""
                        )
                        Text(text = "Moon", modifier = Modifier.padding(all = 5.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun PageLazyColumn() {
    LazyColumn {
        item {
            Card(
                modifier = Modifier
                    .padding(all = 5.dp)
                    .fillMaxWidth()
            ) {
                Row(modifier = Modifier.clickable { Log.e("List", "Sun Clicked") }) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(all = 10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.sun_art_24),
                            contentDescription = ""
                        )
                        Text(text = "Sun", modifier = Modifier.padding(all = 5.dp))
                    }
                }
            }
        }
        item {
            Card(
                modifier = Modifier
                    .padding(all = 5.dp)
                    .fillMaxWidth()
            ) {
                Row(modifier = Modifier.clickable { Log.e("List", "Moon Clicked") }) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(all = 10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.moon_art),
                            contentDescription = ""
                        )
                        Text(text = "Moon", modifier = Modifier.padding(all = 5.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun PageCard() {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Card(
            modifier = Modifier
                .padding(all = 10.dp)
                .fillMaxWidth(),
            elevation = 10.dp,
            backgroundColor = Color.Blue,
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            border = BorderStroke(2.dp, Color.Magenta)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.clickable {
                    Log.e("Sun", "Clicked")
                }
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(all = 10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.sun_art),
                        contentDescription = "description"
                    )
                    Text(
                        text = "Sun", color = Color.White, fontSize = 36.sp
                    )
                }
            }
        }


    }
}

//-----------------------------------------------------------
@Composable
fun PageTopAppBarSearch() {
    val isSearchApplied = remember {
        mutableStateOf(false)
    }
    val tf = remember {
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if (isSearchApplied.value) {
                        TextField(
                            value = tf.value,
                            onValueChange = {
                                tf.value = it
                                Log.e("TopBar", "Search Result : ${it}")
                            },
                            label = { Text(text = "Search") }
                        )
                    } else {
                        Text(text = "Title")
                    }
                },
                actions = {
                    if (isSearchApplied.value) {
                        IconButton(onClick = {
                            isSearchApplied.value = false
                            tf.value = ""
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.close_art),
                                contentDescription = ""
                            )
                        }

                    } else {
                        IconButton(onClick = { isSearchApplied.value = true }) {
                            Icon(
                                painter = painterResource(id = R.drawable.search_art),
                                contentDescription = ""
                            )
                        }

                    }
                }
            )

        },
        content = ({

        })
    )
}


//----------------------------------------------------------------------------------------------------------------------------------------------
@Composable
fun PageTopAppBar() {
    val menuControl = remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(text = "Title")
                        Text(text = "Subtitle", fontSize = 10.sp)
                    }
                },
                backgroundColor = colorResource(id = R.color.main_color),
                contentColor = Color.White,
                actions = {
                    Text(text = "Exit",
                        modifier = Modifier.clickable {
                            Log.e("TopBar", "Exit Clicked")
                        })
                    IconButton(onClick = { Log.e("TopBar", "Info Clicked") }) {
                        Icon(
                            painter = painterResource(id = R.drawable.info_art),
                            contentDescription = ""
                        )
                    }
                    IconButton(onClick = { menuControl.value = true }) {
                        Icon(
                            painter = painterResource(id = R.drawable.more_vert_art),
                            contentDescription = ""
                        )
                    }
                    DropdownMenu(
                        expanded = menuControl.value,
                        onDismissRequest = { menuControl.value = false }) {
                        DropdownMenuItem(onClick = {
                            Log.e("TopBar", "Delete Selected")
                            menuControl.value = false
                        }) {
                            Text(text = "Delete")
                        }
                        DropdownMenuItem(onClick = {
                            Log.e("TopBar", "Update Selected")
                            menuControl.value = false
                        }) {
                            Text(text = "Update")
                        }

                    }
                }
            )
        },
        content = ({

        })
    )


}