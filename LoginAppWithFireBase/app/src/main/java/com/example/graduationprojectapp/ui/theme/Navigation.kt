package com.example.graduationprojectapp.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.graduationprojectapp.home.Home
import com.example.graduationprojectapp.login.LoginScreen
import com.example.graduationprojectapp.login.LoginViewModel
import com.example.graduationprojectapp.login.SignUpScreen

enum class LoginRoutes {
    Signup,
    SignIn
}

enum class HomeRoutes {
    Home,
    Detail
}

@Composable
fun Navigation(
    navController: NavHostController = rememberNavController(),
    loginViewModel: LoginViewModel
) {
    NavHost(navController = navController, startDestination = LoginRoutes.SignIn.name) {
        composable(route = LoginRoutes.SignIn.name) {
            LoginScreen(onNavToHomePage = {
                navController.navigate(HomeRoutes.Home.name) {
                    launchSingleTop = true
                    popUpTo(route = LoginRoutes.SignIn.name) {
                        inclusive = true
                    }
                }
            }) {
                navController.navigate(LoginRoutes.Signup.name) {
                    launchSingleTop = true
                    popUpTo(LoginRoutes.SignIn.name) {
                        inclusive = true
                    }
                }
            }
        }

        composable(route = LoginRoutes.Signup.name) {
            SignUpScreen(onNavToHomePage = {
                navController.navigate(HomeRoutes.Home.name) {
                    popUpTo(LoginRoutes.Signup.name) {
                        inclusive = true
                    }
                }
            }) {
                navController.navigate(LoginRoutes.SignIn.name)
            }
        }

        composable(route = HomeRoutes.Home.name){
            Home()
        }
    }
}