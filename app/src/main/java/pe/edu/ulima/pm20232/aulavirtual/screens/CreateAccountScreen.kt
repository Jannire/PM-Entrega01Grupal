package pe.edu.ulima.pm20232.aulavirtual.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.mukesh.MarkDown
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import pe.edu.ulima.pm20232.aulavirtual.R
import pe.edu.ulima.pm20232.aulavirtual.components.ButtonWithIcon
import pe.edu.ulima.pm20232.aulavirtual.components.CheckboxWithLabel
import pe.edu.ulima.pm20232.aulavirtual.components.TextFieldWithLeadingIcon
import pe.edu.ulima.pm20232.aulavirtual.screenmodels.CreateAccountViewModel
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Gray1200
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Gray400
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Gray800
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Orange400
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.White400
import java.net.URL

@Composable
fun TB(screenHeightDp: Int, screenWidthDp: Int, navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height((screenHeightDp * 0.08).dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_arrow),
            contentDescription = "Arrow",
            modifier = Modifier.clickable{
                println("Regresar a login")
                navController.navigate("login")
            }
                .size(40.dp)
                .padding(start = (screenWidthDp * 0.05).dp),

            colorFilter = ColorFilter.tint(Color.Gray),
        )
        Spacer(modifier = Modifier.weight(1f)) // Add a Spacer with weight
    }
}

@Composable
fun TS(){
    Column(modifier =Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(if (isSystemInDarkTheme()) Color.Black else Gray1200)
                .weight(3f)
                .padding(8.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            val paddingPercentage = 80;
            val paddingValue = with(LocalDensity.current) {
                (paddingPercentage * 0.02f * 16.dp.toPx()).dp
            }
            Column(
                modifier = Modifier.padding(top = paddingValue),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_ulima), // Replace with your SVG resource ID
                    contentDescription = "Universidad de Lima",
                    modifier = Modifier.size(120.dp),
                    colorFilter = ColorFilter.tint(Orange400),
                )
                // Título de la pantalla "Gimnasio Ulima".
                Text(text ="Gimnasio ULima", fontWeight = FontWeight.Bold, fontSize = 14.sp, modifier = Modifier.padding(top = 12.dp))
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(4f)
                .background(if (isSystemInDarkTheme()) Color.DarkGray else White400)
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CreateAccountForm(
    screenWidthDp: Int,
    screenHeightDp: Int,
    viewModel: CreateAccountViewModel,
    coroutineScope: CoroutineScope,
    bottomSheetScaffoldState: BottomSheetScaffoldState,

    ){
    Box( // caja gris (light)
        modifier = Modifier
            .fillMaxSize()
            .padding(top = (screenHeightDp * 0.30).dp)
    ) {
        Box(modifier = Modifier
            .padding(
            start = (screenWidthDp * 0.125).dp,
            top = (40.dp)
        ),){
            Box(
                modifier = Modifier
                    .size(
                        (screenWidthDp * 0.75).dp,
                        (screenHeightDp * 0.60).dp
                    ) // Adjust the size as needed
                    //.border(1.dp, Gray800)
                    .background((if (isSystemInDarkTheme()) Color.DarkGray else White400))
                    .border(1.dp, Gray400) // Se cambio el borde del Login Form según la interface.
                        .padding(start = 40.dp, top = 30.dp, bottom = 20.dp, end = 40.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.verticalScroll(rememberScrollState())
                ){
                    Text(text ="CREAR CUENTA", fontWeight = FontWeight.Medium, fontSize = 12.sp)
                    TextFieldWithLeadingIcon(
                        leadingIcon = Icons.Default.Person, // Replace with your desired icon
                        placeholder = "Nombres",
                        text = viewModel.nombre,
                        onTextChanged = {
                            viewModel.nombre = it.take(25)
                        }
                    )
                    TextFieldWithLeadingIcon(
                        leadingIcon = Icons.Default.Person,
                        placeholder = "Apellidos",
                        text = viewModel.apellido,
                        onTextChanged = {
                            viewModel.apellido = it.take(25)
                        }
                    )
                    TextFieldWithLeadingIcon(
                        leadingIcon = Icons.Default.AccountBox, // Replace with your desired icon
                        placeholder = "DNI",
                        text = viewModel.dni,
                        onTextChanged = {
                            viewModel.dni = it.take(8).filter { char -> char.isDigit() }
                        }
                    )
                    TextFieldWithLeadingIcon(
                        leadingIcon = Icons.Default.Email, // Replace with your desired icon
                        text = viewModel.correo,
                        placeholder = "Correo",
                        onTextChanged = {
                            viewModel.correo = it.take(25)
                        }
                    )
                    TextFieldWithLeadingIcon(
                        leadingIcon = Icons.Default.Call, // Replace with your desired icon
                        placeholder = "Telefono",
                        text = viewModel.telefono,
                        onTextChanged = {
                            viewModel.telefono = it.take(9).filter { char -> char.isDigit() }
                        }
                    )
                    TextFieldWithLeadingIcon(
                        leadingIcon = Icons.Default.Star,
                        placeholder = "Contraseña",
                        text = viewModel.contrasena,
                        onTextChanged = {
                            viewModel.contrasena = it.take(25)
                        },
                        isPassword = true,
                    )
                    TextFieldWithLeadingIcon(
                        leadingIcon = Icons.Default.Star,
                        placeholder = "Repetir Contraseña",
                        text = viewModel.repContrasena,
                        onTextChanged = {
                            viewModel.repContrasena = it.take(25)
                        },
                        isPassword = true,
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 0.dp),
                        horizontalArrangement = Arrangement.Center,
                    ){
                        ButtonWithIcon("CREAR CUENTA", Icons.Default.Email, {
                            viewModel.access()
                        })
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BSheet(screenWidthDp: Int, screenHeightDp: Int, viewModel: CreateAccountViewModel){
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val coroutineScope = rememberCoroutineScope()
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {},
        sheetPeekHeight = 0.dp,
        backgroundColor = Color.Transparent
    ) {
        CreateAccountForm(screenWidthDp, screenHeightDp, viewModel, coroutineScope, bottomSheetScaffoldState)
    }
}

@Composable
fun Res(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.BottomCenter
    ){
    }
}

@Composable
fun CreateAccountScreen(viewModel: CreateAccountViewModel, navController: NavHostController) {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp
    val screenHeightDp = configuration.screenHeightDp
    TS()
    BSheet(screenWidthDp, screenHeightDp, viewModel)
    TB(screenHeightDp, screenWidthDp, navController)
    if(viewModel.bottomSheetCollapse){
        Res()
    }
}