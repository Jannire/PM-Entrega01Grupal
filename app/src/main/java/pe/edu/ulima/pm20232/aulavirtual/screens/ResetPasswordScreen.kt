package pe.edu.ulima.pm20232.aulavirtual.screens
import androidx.compose.material.Text
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
import pe.edu.ulima.pm20232.aulavirtual.screenmodels.ResetPasswordViewModel
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Gray1200
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Gray400
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Gray800
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Orange400
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.White400
import java.net.URL

@Composable
fun BackButton(
   navController: NavController,
   modifier: Modifier = Modifier,
   icon: ImageVector = Icons.Default.ArrowBack,
   contentDescription: String = "Back"
) {
   Row(
      modifier = modifier
         .fillMaxWidth()
         .padding(16.dp),
      horizontalArrangement = Arrangement.Start,
      verticalAlignment = Alignment.CenterVertically
   ) {
      /*
      Icon(
         imageVector = icon,
         contentDescription = contentDescription,
         tint = Color.Black, // Cambia el color según tus preferencias
         modifier = Modifier.clickable {
            navController.popBackStack()
         }
      )*/
      Spacer(modifier = Modifier.padding(4.dp)) // Espaciador opcional para dar espacio entre el icono y otros elementos
   }
}

@Composable
fun TScreen(){
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
               colorFilter = ColorFilter.tint(White400),
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
fun ResetPassForm(
   screenWidthDp: Int,
   screenHeightDp: Int,
   viewModel: ResetPasswordViewModel,
   coroutineScope: CoroutineScope,
   bottomSheetScaffoldState: BottomSheetScaffoldState,

){
   Box( // caja gris (light)
      modifier = Modifier
         .fillMaxSize()
         .padding(top = (screenHeightDp * 0.30).dp)
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
               .background((if (isSystemInDarkTheme()) Color.DarkGray else White400))
               .border(1.dp, Gray400) // Se cambio el borde del Login Form según la interface.
               .padding(start = 20.dp, top = 30.dp, bottom = 20.dp, end = 20.dp)
         ) {
            Column(
               verticalArrangement = Arrangement.Center,
               horizontalAlignment = Alignment.CenterHorizontally
            ){
               Text(text ="SOLICITE CAMBIO DE CONTRASEÑA", fontWeight = FontWeight.Medium, fontSize = 13.sp)
               TextFieldWithLeadingIcon(
                  leadingIcon = Icons.Default.AccountBox, // Replace with your desired icon
                  placeholder = "DNI",
                  text = viewModel.user,
                  onTextChanged = {
                     viewModel.user = it
                  }
               )
               TextFieldWithLeadingIcon(
                  leadingIcon = Icons.Default.Email, // Replace with your desired icon
                  text = viewModel.password,
                  placeholder = "Correo",
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
                  ButtonWithIcon("ENVIAR CORREO", Icons.Default.Email, {
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
fun BottomSheet(screenWidthDp: Int, screenHeightDp: Int, viewModel: ResetPasswordViewModel){
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
      ResetPassForm(screenWidthDp, screenHeightDp, viewModel, coroutineScope, bottomSheetScaffoldState)
   }
}

@Composable
fun Reset(){
   Box(
      modifier = Modifier
         .fillMaxSize()
         .padding(20.dp),
      contentAlignment = Alignment.BottomCenter
   ){
   }
}

@Composable
fun ResetPasswordScreen(viewModel: ResetPasswordViewModel, navController: NavHostController) {
   val configuration = LocalConfiguration.current
   val screenWidthDp = configuration.screenWidthDp
   val screenHeightDp = configuration.screenHeightDp
   BackButton(navController = navController)
   TopScreen()
   BottomSheet(screenWidthDp, screenHeightDp, viewModel)
   if(viewModel.bottomSheetCollapse){
      Reset()
   }
}