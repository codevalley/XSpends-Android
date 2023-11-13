package me.nyn.xspends.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import me.nyn.xspends.R
import me.nyn.xspends.viewmodel.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun WelcomeScreen(navController: NavController, viewModel: AuthViewModel = hiltViewModel()) {
    //Box wrap for center card
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff000000)),
        contentAlignment = Alignment.Center // This will center the Card vertically and horizontally
    ) {
        GradientBackground(0.1f)
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color(0x0003060d),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .border(
                    width = 1.dp,
                    color = Color(0x7f273a31),
                    shape = RoundedCornerShape(16.dp) // Set a rounded shape for the border if desired
                )
                .clip(RoundedCornerShape(16.dp)), // Clip the Card to have rounded corners,
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(0.dp)
                    .background(Color(0xFF000000)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.height(24.dp))
                // Logo
                Image(
                    painter = painterResource(id = R.drawable.logomark),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(72.dp)
                        .padding(8.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                // App name
                Text(
                    text = "XSpends",
                    fontWeight = FontWeight.Bold,
                    fontSize = 36.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                // Tagline
                Text(
                    text = "Sign up to create an account and explore many things",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White.copy(alpha = 0.5f),
                    modifier = Modifier.padding(horizontal = 24.dp),
                    fontFamily = FontFamily.SansSerif

                )
                Spacer(modifier = Modifier.height(36.dp))
            }
                Column(
                    modifier = Modifier
                        .background(Color(0xff0d1017)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    // Register button with Google icon
                    Spacer(modifier = Modifier.height(36.dp))
                Button(
                    onClick = {
                        // TODO: Implement registration logic
                    },
                    colors = ButtonDefaults.buttonColors(containerColor =Color(0xff0c1016), contentColor = Color(0xffe0e3e6)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 36.dp)
                        .height(50.dp)
                        .border(
                            width = 1.dp,
                            color = Color(0x7f273a31),
                            shape = RoundedCornerShape(16.dp) // Set a rounded shape for the border if desired
                        )
                ) {
                    Icon(
                        painter = painterResource(id = com.google.android.material.R.drawable.material_ic_calendar_black_24dp), // Replace with actual Google logo resource ID
                        contentDescription = "Google logo",
                        tint = Color.White // Keep the original logo colors
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text(
                        text = "Register",
                        fontSize = 16.sp)
                }
                Spacer(modifier = Modifier.height(8.dp))
                // Login text button
                TextButton(
                    onClick = {
                        // TODO: Navigate to login screen
                    }
                ) {
                    Text(
                        text = "Or Login to existing account",
                        color = Color.White.copy(alpha = 0.7f),
                        fontSize = 18.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                }
                    Spacer(modifier = Modifier.height(24.dp))
            } // End of Column
        } // End of Card

    } // End of RegisterScreen Composable
}

@Composable
fun GradientBackground(opacity: Float = .2f) {
    var size = IntSize.Zero // To store the size of the Canvas

    Box(modifier = Modifier.fillMaxSize()) {
        Canvas(modifier = Modifier
            .matchParentSize()
            .onSizeChanged {
                size = it
            }
        ) {
            // Define the colors with the given opacity
            val topGradientColors = listOf(Color(0xFF069CDF).copy(alpha = opacity), Color.Transparent)
            val bottomGradientColors = listOf(Color(0xFFEC4899).copy(alpha = opacity), Color.Transparent)

            // Draw the black solid background with opacity
            drawRect(
                color = Color.Black.copy(alpha = opacity),
                size = size.toSize()
            )

            // Draw the top radial gradient
            drawCircle(
                brush = Brush.radialGradient(
                    colors = topGradientColors,
                    center = Offset(size.width / 2f, 0f),
                    radius = size.width.toFloat(),
                    tileMode = TileMode.Clamp
                ),
                center = Offset(size.width / 2f, 0f),
                radius = size.width.toFloat()
            )

            // Draw the bottom radial gradient
            drawCircle(
                brush = Brush.radialGradient(
                    colors = bottomGradientColors,
                    center = Offset(size.width / 2f, size.height.toFloat()),
                    radius = size.width.toFloat(),
                    tileMode = TileMode.Clamp
                ),
                center = Offset(size.width / 2f, size.height.toFloat()),
                radius = size.width.toFloat()
            )
        }

        // Your UI components go here
    }
}
