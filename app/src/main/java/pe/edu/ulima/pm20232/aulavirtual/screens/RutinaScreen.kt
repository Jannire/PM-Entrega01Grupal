package pe.edu.ulima.pm20232.aulavirtual.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import androidx.compose.ui.unit.toSize
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import pe.edu.ulima.pm20232.aulavirtual.R
import pe.edu.ulima.pm20232.aulavirtual.screenmodels.HomeScreenViewModel
import pe.edu.ulima.pm20232.aulavirtual.screenmodels.ProfileScreenViewModel
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Gray1200
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Orange400
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.White400


@Composable
fun Activities(screenWidthDp: Int, screenHeightDp: Int){
    Column() {
        Image(
            painter = painterResource(id = R.drawable.linea), // Replace with your SVG resource ID
            contentDescription = "linea",
            modifier = Modifier.width(screenWidthDp.dp),
            colorFilter = ColorFilter.tint(Orange400),
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height((screenHeightDp * 0.16).dp)   // SCREEN: 16%
                .background(if (isSystemInDarkTheme()) Color.Black else Color.White) // Change color
        ) {
            Column(
                modifier = Modifier
                    .padding(start = (screenWidthDp * 0.1).dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
            ) {

                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally), // Center the text horizontally
                    text = "22", // Add Advanced Text
                    textAlign = TextAlign.Center,
                    color = if (isSystemInDarkTheme()) White400 else Color.Black, // Apply the custom text color here
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    text = "Ejercicios Asignados", // Add Advanced Text
                    textAlign = TextAlign.Center,
                    color = if (isSystemInDarkTheme()) White400 else Color.Black, // Apply the custom text color here
                    fontSize = 15.sp
                )
            }
            Column(
                modifier = Modifier
                    .padding(
                        start = (screenWidthDp * 0.1).dp,
                        end = (screenWidthDp * 0.1).dp
                    )
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    text = "4", // Add Advanced Text
                    textAlign = TextAlign.Center,
                    color = if (isSystemInDarkTheme()) White400 else Color.Black, // Apply the custom text color here
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,

                    )
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    text = "Partes del cuerpo entrenadas", // Add Advanced Text
                    textAlign = TextAlign.Center,
                    color = if (isSystemInDarkTheme()) White400 else Color.Black, // Apply the custom text color here
                    fontSize = 15.sp
                )
            }

        }
        Image(
            painter = painterResource(id = R.drawable.linea), // Replace with your SVG resource ID
            contentDescription = "linea",
            modifier = Modifier.width(screenWidthDp.dp),
            colorFilter = ColorFilter.tint(Orange400),
        )
    }
}

@Composable
fun DropdownMenu(){
    var expanded by remember {mutableStateOf(false)}
    val suggestions = listOf("Pecho","Espalda","Piernas","Abdomen")
    var selectedText by remember { mutableStateOf("") }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if(expanded)
                Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(value = selectedText, onValueChange = { selectedText = it},
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                },
            label = {Text("Label")},
            trailingIcon = {
                Icon(icon, "ContentDescription",
                    Modifier.clickable { expanded = !expanded })
            }
        )


        /*
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {expanded = false},
            modifier = Modifier.width(with(LocalDensity.current){textFieldSize.width.toDp()})
        )

        //EN MAP DEBERÍA IR EL LISTADO MENCIONADO DE LOS EJERCICIOS
        // Me quedé en minuto 1:39:43 de la grabación de 2/10/2023
        {
            for ((key,value) in map) {
                DropdownMenuItem(onClick = {
                    selectedText = value
                    expanded = false})
                {
                    Text(text = value)
                }
            }
        }
        */
    }
}

@Composable
fun FinalRutinaScreen(screenHeightDp: Int, screenWidthDp: Int, imageUrl: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White) // Background color, changes in dark mode
    ) {
        TopBar(screenHeightDp, screenWidthDp)
        Activities(screenWidthDp, screenHeightDp)

    }
}

@Composable
fun RutinaScreen(navController: NavController, viewModel: ProfileScreenViewModel) {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp
    val screenHeightDp = configuration.screenHeightDp
    val imageUrl =
        "https://wallpapers.com/images/hd/cute-cat-eyes-profile-picture-uq3edzmg1guze2hh.jpg" // Replace with your image URL
    FinalRutinaScreen(screenHeightDp, screenWidthDp, imageUrl)
}