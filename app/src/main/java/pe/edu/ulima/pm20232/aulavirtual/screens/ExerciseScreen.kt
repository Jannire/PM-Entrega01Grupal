package pe.edu.ulima.pm20232.aulavirtual.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import androidx.compose.ui.unit.toSize
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import pe.edu.ulima.pm20232.aulavirtual.screenmodels.ExerciseScreenViewModel
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Gray1200
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import coil.annotation.ExperimentalCoilApi
import pe.edu.ulima.pm20232.aulavirtual.models.Exercise


@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalFoundationApi::class, ExperimentalCoilApi::class)
@Composable
fun ExercisesGrid(navController: NavController, model: ExerciseScreenViewModel) {
    var showDialog by remember { mutableStateOf(false) }
    var selectedExercise by remember { mutableStateOf(Exercise(0, "", "", "", "", 0)) }

    val exercises by model.exercises.collectAsState()

    LazyVerticalGrid(
        cells = GridCells.Fixed(3)
    ) {
        items(exercises.size) { i ->
            Column() {
                println(exercises[i].imageUrl)
                Image(
                    painter = rememberImagePainter(data = exercises[i].imageUrl),
                    contentDescription = exercises[i].name,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(bottom = 10.dp)
                        .clickable {
                            selectedExercise = exercises[i]
                            showDialog = true
                        },
                )
                Text(exercises[i].name)
            }
        }
    }

    // Show dialog when showDialog is true
    ShowDialog(
        showDialog = mutableStateOf(showDialog),
        exercise = selectedExercise,
    )
}

@Composable
fun ShowDialog(showDialog: MutableState<Boolean>, exercise: Exercise) {
    var dialogClosed by remember { mutableStateOf(false) }

    if (showDialog.value && !dialogClosed) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AlertDialog(
                onDismissRequest = {
                    // Esta es la acción de descartar el diálogo, asegúrate de manejarla correctamente
                    showDialog.value = false
                    dialogClosed = true
                },
                title = {
                    Text(
                        text = exercise.name,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                },
                text = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Description: ${exercise.description}",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp, bottom = 8.dp),
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "Video URL: ${exercise.videoUrl}",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                            // Esta es la acción del botón OK, también puedes manejarla según sea necesario
                            showDialog.value = false
                            dialogClosed = true
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        content = {
                            Text(
                                text = "OK",
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }
                    )
                },
                backgroundColor = Color.LightGray,
                modifier = Modifier.align(Alignment.Center)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
                    .clickable {
                        // También puedes cerrar el diálogo si se hace clic fuera de él
                        showDialog.value = false
                        dialogClosed = true
                    }
            )
        }
    }
}



@Composable
fun ExerciseScreen(navController: NavController, model: ExerciseScreenViewModel){
    model.getBodyParts()
    model.listAllExercises()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ){
        SelectOpitions(model)
        ExercisesGrid(navController, model)
    }
}

@Composable
fun SelectOpitions(model: ExerciseScreenViewModel) {
    var expanded by remember { mutableStateOf(false) }
    // val suggestions = listOf("Kotlin", "Java", "Dart", "Python")
    var selectedText by remember { mutableStateOf("") }
    var textfieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown
    Column(
        Modifier.padding(bottom = 20.dp)
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
                disabledLabelColor = (if (isSystemInDarkTheme()) Gray1200 else Color.Black),
                disabledBorderColor = (if (isSystemInDarkTheme()) Gray1200 else Color.Black),
                disabledTextColor = (if (isSystemInDarkTheme()) Gray1200 else Color.Black)
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
                }) {
                    Text(text = value)
                }
            }
        }
    }
}

