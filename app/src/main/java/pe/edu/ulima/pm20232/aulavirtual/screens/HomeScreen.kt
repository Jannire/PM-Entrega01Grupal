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
import androidx.compose.foundation.layout.fillMaxHeight
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
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Gray1200
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Orange400
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.White400
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import pe.edu.ulima.pm20232.aulavirtual.screenmodels.LoginScreenViewModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExercisesGrid(navController: NavController, model: HomeScreenViewModel){
    var intValue by remember { mutableStateOf(0) }
    val exercises by model.exercises.collectAsState()
    LazyVerticalGrid(
        cells = GridCells.Fixed(3) // Specify the number of columns
    ) {
        items(exercises.size) { i ->
            Column(){
                println(exercises[i].imageUrl)
                Image(
                    painter = rememberImagePainter(data = exercises[i].imageUrl),
                    contentDescription = exercises[i].name,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(bottom = 10.dp)
                        .clickable {
                            intValue = exercises[i].id.toInt()
                            navController.navigate("${intValue}ejercicios/abdomen01.png")
                        },
                )
                Text(exercises[i].name)
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavController, loginModel: LoginScreenViewModel, model: HomeScreenViewModel){
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp
    val screenHeightDp = configuration.screenHeightDp

    val user = remember { loginModel.user }
    val password = remember { loginModel.password }

    model.getBodyParts()
    model.listAllExercises()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ){
        Activities(screenWidthDp , screenHeightDp)
        SelectOpitions(model)
        ExercisesGrid(navController, model)
    }
}

@Composable
fun SelectOpitions(model: HomeScreenViewModel) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("") }
    var textfieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown
    Column(
        Modifier.padding(bottom = 20.dp, top = 20.dp)
    ) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    //This value is used to assign to the DropDown the same width
                    textfieldSize = coordinates.size.toSize()
                },
            label = { Text("Lista de Partes del Cuerpo") },
            trailingIcon = {
                Icon(icon,"contentDescription",
                    Modifier.clickable { expanded = !expanded })
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                disabledLabelColor = Color.Black, // Change the label color when disabled
                disabledBorderColor = Gray1200, // Change the border color when disabled
                disabledTextColor = Color.Black
            )
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current){textfieldSize.width.toDp()})
        ) {
            for ((key, value) in model.bodyPartsMap) {
                DropdownMenuItem(onClick = {
                    model.filterByBodyParts(key)
                    selectedText = value
                    expanded = false
                })
                {
                    Text(text = value,
                        color = Color.Black)
                }
            }
        }
    }
}

@Composable
fun Activities(screenWidthDp: Int, screenHeightDp: Int){
    Column() {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height((screenHeightDp * 0.16).dp)   // SCREEN: 16%
                .background(if (isSystemInDarkTheme()) Color.Black else Color.White) // Change color
        ) {
            Column(
                modifier = Modifier.padding(start = (screenWidthDp * 0.1).dp)
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
                modifier = Modifier.padding(
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
