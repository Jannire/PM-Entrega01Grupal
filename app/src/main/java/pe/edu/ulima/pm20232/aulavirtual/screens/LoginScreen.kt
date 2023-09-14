package pe.edu.ulima.pm20232.aulavirtual.screens

import android.widget.ScrollView
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.mukesh.MarkDown
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import pe.edu.ulima.pm20232.aulavirtual.R
import pe.edu.ulima.pm20232.aulavirtual.components.ButtonWithIcon
import pe.edu.ulima.pm20232.aulavirtual.components.CheckboxWithLabel
import pe.edu.ulima.pm20232.aulavirtual.components.TextFieldWithLeadingIcon
import pe.edu.ulima.pm20232.aulavirtual.screenmodels.LoginScreenViewModel
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.*
import java.net.URL
import androidx.compose.material.Text as Text1

@Composable
fun TopScreen(){
    Column(modifier =Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Orange400)
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
                    colorFilter = ColorFilter.tint(White400),
                )
                Text1(
                    text = "Gimnasio UL",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    //fontSize = 40.sp,
                    modifier =  Modifier.padding(top = 20.dp, bottom = 20.dp),
                        style = MaterialTheme.typography.h4.copy(
                        fontSize = 40.sp,
                        fontFamily = FontFamily(Font(R.font.caslon_classico_sc_regular)),
                        color = if (isSystemInDarkTheme()) White400 else Orange400 // Apply the custom text color here
                    )
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LoginForm(
    screenWidthDp: Int,
    screenHeightDp: Int,
    viewModel: LoginScreenViewModel,
    coroutineScope: CoroutineScope,
    bottomSheetScaffoldState: BottomSheetScaffoldState
){
    var termsDisabled = true

    Box( // caja gris (light)
        modifier = Modifier
            .fillMaxSize()
            .padding(top = (screenHeightDp * 0.30).dp,)
            .background(Gray1200),
    ) {
        Box(modifier = Modifier.padding(
            start = (screenWidthDp * 0.125).dp,
            top = (40.dp)
        ),){
            Box(
                modifier = Modifier
                    .size(
                        (screenWidthDp * 0.75).dp,
                        (screenHeightDp * 0.45).dp
                    ) // Adjust the size as needed
                    //.border(1.dp, Gray800)
                    .background(White400)
                    .shadow(
                        elevation = 5.dp,
                        shape = MaterialTheme.shapes.medium,
                        //color = Color.Gray
                    )
                    .padding(start = 20.dp, top = 30.dp, bottom = 20.dp, end = 20.dp),
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text1(text ="Bienvenido al Sistema", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    TextFieldWithLeadingIcon(
                        leadingIcon = Icons.Default.Person, // Replace with your desired icon
                        placeholder = "Usuario",
                        text = viewModel.user,
                        onTextChanged = {
                            viewModel.user = it
                        }
                    )
                    TextFieldWithLeadingIcon(
                        leadingIcon = Icons.Default.Lock, // Replace with your desired icon
                        text = viewModel.password,
                        placeholder = "Contraseña",
                        onTextChanged = {
                            viewModel.password = it
                        },
                        isPassword = true,
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 25.dp),
                        horizontalArrangement = Arrangement.Center,
                    ){
                        ButtonWithIcon("INGRESAR", Icons.Default.Person, {
                            viewModel.access()
                        })
                    }
                    CheckboxWithLabel(
                        label = "Términos y Condiciones",
                        isChecked = viewModel.termsAndConditionsChecked,
                        onCheckedChange = {
                            viewModel.termsAndConditionsChecked = it
                        },
                        onClick = {
                            if(!termsDisabled){
                                viewModel.termsAndConditionsChecked = !viewModel.termsAndConditionsChecked
                            }
                            coroutineScope.launch {
                                if (bottomSheetScaffoldState.bottomSheetState.isCollapsed){
                                    viewModel.bottomSheetCollapse = false
                                    bottomSheetScaffoldState.bottomSheetState.expand()
                                }else{
                                    viewModel.bottomSheetCollapse = true
                                    bottomSheetScaffoldState.bottomSheetState.collapse()
                                }
                            }
                        },
                        disabled = termsDisabled,
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TermsAndConditions(viewModel: LoginScreenViewModel, bottomSheetScaffoldState: BottomSheetScaffoldState){
    val coroutineScope = rememberCoroutineScope()
    Box(
        Modifier.fillMaxWidth().height(500.dp).background(Color.White).padding(top = 20.dp)
    ){
        Column(
            Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            MarkDown(
                url = URL("https://raw.githubusercontent.com/mukeshsolanki/MarkdownView-Android/main/README.md"),
                modifier = Modifier.fillMaxSize()
            )
        }
    }
    Box(
        Modifier.fillMaxWidth().height(87.dp).background(Gray1200)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center, // Center horizontally
        ){
            Box(
                modifier = Modifier
                    .weight(1f).padding(start = 5.dp, end = 5.dp) // Equal weight for the first part
            ) {
                ButtonWithIcon(
                    text = "Acepto", icon = Icons.Default.Check, onClick  = {
                        coroutineScope.launch {
                            viewModel.bottomSheetCollapse = true
                            viewModel.termsAndConditionsChecked = true
                            bottomSheetScaffoldState.bottomSheetState.collapse()
                        }
                    }, modifier = Modifier.height(55.dp).fillMaxWidth(), backgroundColor = Gray800)
            }
            Box(
                modifier = Modifier
                    .weight(1f).padding(start = 5.dp, end = 5.dp) // Equal weight for the second part
            ) {
                ButtonWithIcon("No Acpeto", Icons.Default.Delete, onClick = {
                    coroutineScope.launch {
                        viewModel.bottomSheetCollapse = true
                        viewModel.termsAndConditionsChecked = false
                        bottomSheetScaffoldState.bottomSheetState.collapse()
                    }
                }, modifier = Modifier.height(55.dp).fillMaxWidth(), backgroundColor = Gray800)
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheet(screenWidthDp: Int, screenHeightDp: Int, viewModel: LoginScreenViewModel){
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val coroutineScope = rememberCoroutineScope()
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            TermsAndConditions(viewModel, bottomSheetScaffoldState)
        },
        sheetPeekHeight = 0.dp,
        backgroundColor = Color.Transparent
    ) {
        LoginForm(screenWidthDp, screenHeightDp, viewModel, coroutineScope, bottomSheetScaffoldState)
    }
}

@Composable
fun GoToReset(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.BottomCenter
    ){
        Row() {
            Text1(text = "Olvidó su contraseña? ", textAlign = TextAlign.End, color = Gray800, fontSize = 16.sp)
            Text1(
                text = "Cambiala Aquí",
                textAlign = TextAlign.End,
                color = Orange400,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    println("Cambiar Contraseña")
                },
            )
        }
    }
}

@Composable
fun LoginScreen(viewModel: LoginScreenViewModel, navController: NavHostController) {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp
    val screenHeightDp = configuration.screenHeightDp
    TopScreen()
    BottomSheet(screenWidthDp, screenHeightDp, viewModel)
    if(viewModel.bottomSheetCollapse){
        GoToReset()
    }
}
