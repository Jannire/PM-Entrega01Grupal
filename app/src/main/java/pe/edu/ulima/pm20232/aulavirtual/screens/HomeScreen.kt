package pe.edu.ulima.pm20232.aulavirtual.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import pe.edu.ulima.pm20232.aulavirtual.screenmodels.HomeScreenViewModel
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Gray1200
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Orange400
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.White400
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mukesh.MarkDown
import pe.edu.ulima.pm20232.aulavirtual.models.Exercise
import pe.edu.ulima.pm20232.aulavirtual.models.ExerciseMember
import pe.edu.ulima.pm20232.aulavirtual.screenmodels.LoginScreenViewModel
import pe.edu.ulima.pm20232.aulavirtual.services.ExerciseMemberService
import pe.edu.ulima.pm20232.aulavirtual.services.ExerciseService
import pe.edu.ulima.pm20232.aulavirtual.services.UserService
import java.net.URL
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExercisesGrid(navController: NavController, model: HomeScreenViewModel, userId: Int) {
    var intValue by remember { mutableStateOf(0) }
    val exercises by model.exercises.collectAsState()
    var selectedExerciseIndex by remember { mutableStateOf(-1) }
    val showDialog = remember { mutableStateOf(false) }
    val currentExercise = if (selectedExerciseIndex != -1) exercises[selectedExerciseIndex] else null
    val exerciseMember = if (currentExercise != null) model.getExerciseMemberForUser(userId, currentExercise.id) else null

    LazyVerticalGrid(
        cells = GridCells.Fixed(3)
    ) {
        items(exercises.size) { i ->
            Column() {
                println(exercises[i].imageUrl)
                Box(
                    modifier = Modifier
                        .size(80.dp) // Reduced the size of the cells' images
                        .padding(bottom = 10.dp)
                        .clickable {
                            selectedExerciseIndex = i
                            showDialog.value = true
                        }
                ) {
                    Image(
                        painter = rememberImagePainter(data = exercises[i].imageUrl),
                        contentDescription = exercises[i].name
                    )
                }
                Text(exercises[i].name)
            }
        }
    }

    if (currentExercise != null && exerciseMember != null) {
        ShowDialog(showDialog, currentExercise, exerciseMember)
    }
}

@Composable
fun ShowDialog(showDialog: MutableState<Boolean>, exercise: Exercise, exerciseMember: ExerciseMember) {
    if (showDialog.value) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            androidx.compose.material.AlertDialog(
                onDismissRequest = {
                    showDialog.value = false
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
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        text = "Repetitions",
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Center
                                    )
                                    Text(
                                        text = "Sets",
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Center
                                    )
                                }
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        text = exerciseMember.reps.toString(),
                                        textAlign = TextAlign.Center
                                    )
                                    Text(
                                        text = exerciseMember.sets.toString(),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
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
                        onClick = { showDialog.value = false },
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
            )
        }
    }
}



@Composable
fun HomeScreen(navController: NavController, loginModel: LoginScreenViewModel, model: HomeScreenViewModel, userId: Int) {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp
    val screenHeightDp = configuration.screenHeightDp

    var assignedExerciseCount = 0 //mutableStateOf(0);
    var trainedBodyPartsCount = 0 //mutableStateOf(0);
    var temp = model.fetchBodyPartsExercises()

    assignedExerciseCount = temp.first
    trainedBodyPartsCount = temp.second

    model.getBodyParts()

    if (userId != null) {
        model.listAssignedExercises(userId)
    } else {
        model.listAllExercises()
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Activities(assignedExerciseCount, trainedBodyPartsCount, screenWidthDp, screenHeightDp)
        SelectOptions(model,userId)
        ExercisesGrid(navController, model, userId)
    }
}


@Composable
fun SelectOptions(model: HomeScreenViewModel, userId: Int) {
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
                    // This value is used to assign to the DropDown the same width
                    textfieldSize = coordinates.size.toSize()
                },
            label = { Text("Lista de Partes del Cuerpo") },
            trailingIcon = {
                Icon(icon,"contentDescription",
                    Modifier.clickable { expanded = !expanded })
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                disabledLabelColor = Color.Black,
                disabledBorderColor = Gray1200,
                disabledTextColor = Color.Black
            ))
    }
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
        modifier = Modifier
            .width(with(LocalDensity.current) { textfieldSize.width.toDp() })
    ) {
        DropdownMenuItem(onClick = {
            selectedText = ""
            expanded = false
            model.listAssignedExercises(userId) // Unfilter the grid
        }) {
            Text("Quitar Filtro", color = Color.Black)
        }
        for ((key, value) in model.bodyPartsMap) {
            DropdownMenuItem(onClick = {
                selectedText = value
                expanded = false
                model.filterByBodyParts(userId, key) // Call the filterByBodyParts function here
            }) {
                Text(text = value, color = Color.Black)
            }
        }
    }
}


@Composable
fun Activities(assignedExerciseCount: Int, trainedBodyPartsCount: Int, screenWidthDp: Int, screenHeightDp: Int) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height((screenHeightDp * 0.16).dp)
                .background(if (isSystemInDarkTheme()) Color.Black else Color.White)
        ) {
            Column(
                modifier = Modifier
                    .padding(start = (screenWidthDp * 0.1).dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    text = assignedExerciseCount.toString(),
                    textAlign = TextAlign.Center,
                    color = if (isSystemInDarkTheme()) White400 else Color.Black,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    text = "Ejercicios Asignados",
                    textAlign = TextAlign.Center,
                    color = if (isSystemInDarkTheme()) White400 else Color.Black,
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
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    text = trainedBodyPartsCount.toString(),
                    textAlign = TextAlign.Center,
                    color = if (isSystemInDarkTheme()) White400 else Color.Black,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    text = "Partes del cuerpo entrenadas",
                    textAlign = TextAlign.Center,
                    color = if (isSystemInDarkTheme()) White400 else Color.Black,
                    fontSize = 15.sp
                )
            }
        }
    }
}
