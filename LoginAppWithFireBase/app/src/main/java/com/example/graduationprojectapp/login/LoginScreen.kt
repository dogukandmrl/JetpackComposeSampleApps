package com.example.graduationprojectapp.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel? = null,
    onNavToHomePage: () -> Unit,
    onNavToSignUpPage: () -> Unit,
) {
    val loginUiState = loginViewModel?.loginUiState
    val isError = loginUiState?.loginError != null
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Login",
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.Black,
            color = MaterialTheme.colors.primary
        )
        if (isError) {
            Text(text = loginUiState?.loginError ?: "unknown error", color = Color.Red)
        }
        OutlinedTextField(
            value = loginUiState?.userName ?: "",
            onValueChange = {
                loginViewModel?.onUserNameChange(it)
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = "")
            },
            label = {
                Text(text = "Email")
            },
            isError = isError
        )
        OutlinedTextField(
            value = loginUiState?.password ?: "",
            onValueChange = {
                loginViewModel?.onPasswordChange(it)
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "")
            },
            label = {
                Text(text = "Password")
            },
            isError = isError,
            visualTransformation = PasswordVisualTransformation()
        )
        Button(onClick = { loginViewModel?.loginUser(context) }) {
            Text(text = "Sign In")
        }
        Spacer(modifier = Modifier.size(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(text = "Don't have an account ? ")
            Spacer(modifier = Modifier.size(8.dp))
            TextButton(onClick = { onNavToSignUpPage.invoke() }) {
                Text(text = "SignUp")
            }
        }
        if (loginUiState?.isLoading==true){
            CircularProgressIndicator()
        }
        LaunchedEffect(key1 = loginViewModel?.hasUser ){
            if( loginViewModel?.hasUser == true){
                onNavToHomePage.invoke()
            }
        }
    }


}

@Composable
fun SignUpScreen(
    loginViewModel: LoginViewModel? = null,
    onNavToHomePage: () -> Unit,
    onNavToLoginPage: () -> Unit,
) {
    val loginUiState = loginViewModel?.loginUiState
    val isError = loginUiState?.signUpError != null
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "SignUP",
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.Black,
            color = MaterialTheme.colors.primary
        )
        if (isError) {
            Text(text = loginUiState?.signUpError ?: "unknown error", color = Color.Red)
        }
        OutlinedTextField(
            value = loginUiState?.usernameSignUp ?: "",
            onValueChange = {
                loginViewModel?.onUserNameChangeSignUp(it)
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = "")
            },
            label = {
                Text(text = "Email")
            },
            isError = isError
        )
        OutlinedTextField(
            value = loginUiState?.passwordSignUp ?: "",
            onValueChange = {
                loginViewModel?.onPasswordChangeSignUp(it)
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "")
            },
            label = {
                Text(text = "Password")
            },
            isError = isError,
            visualTransformation = PasswordVisualTransformation()
        )
        OutlinedTextField(
            value = loginUiState?.confirmPasswordSignUp ?: "",
            onValueChange = {
                loginViewModel?.onConfirmPasswordChange(it)
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "")
            },
            label = {
                Text(text = "Confirm Password")
            },
            isError = isError,
            visualTransformation = PasswordVisualTransformation()
        )
        Button(onClick = { loginViewModel?.createUser(context) }) {
            Text(text = "Sign In")
        }
        Spacer(modifier = Modifier.size(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(text = "Already have an account ? ")
            Spacer(modifier = Modifier.size(8.dp))
            TextButton(onClick = { onNavToLoginPage.invoke() }) {
                Text(text = "Sign In")
            }
        }
        if (loginUiState?.isLoading==true){
            CircularProgressIndicator()
        }
        LaunchedEffect(key1 = loginViewModel?.hasUser ){
            if( loginViewModel?.hasUser == true){
                onNavToHomePage.invoke()
            }
        }
    }
}

