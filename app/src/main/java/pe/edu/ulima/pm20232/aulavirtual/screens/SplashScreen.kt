package pe.edu.ulima.pm20232.aulavirtual.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import pe.edu.ulima.pm20232.aulavirtual.R
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Gray800
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Orange400
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.White400

@Preview
@Composable
fun SplashScreenPreview(){
    SplashScreen(navigateToMain = {})
}

@Composable
fun SplashScreen(navigateToMain: () -> Unit
) {
    // Add your splash screen content here
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Gray800 else White400),
        contentAlignment = Alignment.CenterStart
    ) {
        // Display your splash screen content
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.ic_ulima), // Replace with your SVG resource ID
                contentDescription = "Universidad de Lima",
                modifier = Modifier.size(80.dp),
                colorFilter = ColorFilter.tint(if (isSystemInDarkTheme()) White400 else Orange400),
            )
            Text(
                modifier = Modifier.padding(top = 5.dp),
                text = "Universidad \n de Lima",
                style = MaterialTheme.typography.h4.copy(
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.caslon_classico_sc_regular)),
                    color = if (isSystemInDarkTheme()) White400 else Orange400 // Apply the custom text color here
                ),
                textAlign = TextAlign.Center,
            )
        }
    }

    // Simulate a delay and then navigate to the main screen
    LaunchedEffect(Unit) {
        delay(1000) // Adjust the delay duration as needed
        navigateToMain()
    }
}