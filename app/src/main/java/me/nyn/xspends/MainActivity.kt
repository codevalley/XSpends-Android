package me.nyn.xspends

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import me.nyn.xspends.ui.theme.XSpendsTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import me.nyn.xspends.ui.screens.WelcomeScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            XSpendsTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "register") {
                    composable("register") { WelcomeScreen(navController) }
                    // Define composable for other screens
                }
            }
        }
    }
}
