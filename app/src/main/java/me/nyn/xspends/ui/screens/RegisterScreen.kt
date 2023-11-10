package me.nyn.xspends.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import me.nyn.xspends.viewmodel.AuthViewModel
import me.nyn.xspends.viewmodel.RegisterUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavController, viewModel: AuthViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    TextField(value = username, onValueChange = { username = it }, label = { Text("Username") })
    TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
    TextField(value = password, onValueChange = { password = it }, label = { Text("Password") })
    Button(onClick = { viewModel.register(username, password, email) }) {
        Text("Register")
    }

    when (uiState) {
        is RegisterUiState.Loading -> {
            // Show loading indicator
        }
        is RegisterUiState.Success -> {
            // Handle success, navigate to another screen, etc.
        }
        is RegisterUiState.Error -> {
            // Show error message
        }
        else -> {
            // Perhaps do nothing or reset the UI to an empty state
        }
    }

}
