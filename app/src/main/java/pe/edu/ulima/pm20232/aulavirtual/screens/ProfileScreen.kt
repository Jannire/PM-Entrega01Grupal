package pe.edu.ulima.pm20232.aulavirtual.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import pe.edu.ulima.pm20232.aulavirtual.R
import pe.edu.ulima.pm20232.aulavirtual.configs.BackendClient
import pe.edu.ulima.pm20232.aulavirtual.models.Member
import pe.edu.ulima.pm20232.aulavirtual.screenmodels.LoginScreenViewModel
import pe.edu.ulima.pm20232.aulavirtual.screenmodels.ProfileScreenViewModel
import pe.edu.ulima.pm20232.aulavirtual.services.MemberService
import pe.edu.ulima.pm20232.aulavirtual.services.MemberServiceAntiguoELIMINAR
import pe.edu.ulima.pm20232.aulavirtual.services.UserService
import pe.edu.ulima.pm20232.aulavirtual.services.UserService2
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Gray800
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Orange400
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Orange800
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.White400
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.White800
import java.util.Objects.toString

@Composable
fun ImageView(url: String, height: Int, width: Int) {
    val painter = rememberImagePainter(data = url, builder = {
        // You can apply transformations here if needed
        transformations(CircleCropTransformation())
    })
    Image(
        painter = painter,
        contentDescription = null, // Set a proper content description if required
        modifier = Modifier
            .size(width.dp, height.dp)
    )
}

@Composable
fun TopBar(screenHeightDp: Int, screenWidthDp: Int, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height((screenHeightDp * 0.08).dp)
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_arrow),
            contentDescription = "Arrow",
            modifier = Modifier
                .size(40.dp)
                .padding(start = (screenWidthDp * 0.05).dp)
                .clickable { navController.navigate("home") },
            colorFilter = ColorFilter.tint(Color.Gray),
        )
        Spacer(modifier = Modifier.weight(1f)) // Add a Spacer with weight
        Image(
            painter = painterResource(id = R.drawable.ic_edit),
            contentDescription = "Pencil",
            modifier = Modifier
                .size(40.dp)
                .padding(end = (screenWidthDp * 0.05).dp),
            colorFilter = ColorFilter.tint(Color.Gray),
        )
    }
}

@Composable
fun UserCard(screenHeightDp: Int, screenWidthDp: Int, model: ProfileScreenViewModel) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height((screenHeightDp * 0.20).dp) // SCREEN: 20%
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White)
            .padding(start = (screenWidthDp * 0.1).dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        ImageView(url = model.img, width = 100, height = 100) // No adaptability
        Column(
            modifier = Modifier
                .padding(start = (screenWidthDp * 0.08).dp),
        ) {
            if (model.name != null) {
                Text(
                    text = model.name+" "+model.lname,
                    style = TextStyle(
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = if (isSystemInDarkTheme()) White400 else Color.Black,
                    ),
                    modifier = Modifier.padding(bottom = (screenHeightDp * 0.01).dp)
                )
            }
            Row(
                modifier = Modifier.padding(bottom = (screenHeightDp * 0.01).dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_persona),
                    contentDescription = "Icono persona",
                    modifier = Modifier.size(16.dp),
                    colorFilter = ColorFilter.tint(if (isSystemInDarkTheme()) Color.White else Color.Black),
                )
                Text(
                    text = model.email,
                    style = TextStyle(
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = if (isSystemInDarkTheme()) White400 else Color.Gray
                    ), modifier = Modifier.padding(start = (screenWidthDp * 0.01).dp)
                )
            }
            Text(
                text = model.level,
                style = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = if (isSystemInDarkTheme()) White400 else Color.Gray,
                ), modifier = Modifier.padding(start = (screenWidthDp * 0.05).dp)
            )
        }
    }

}
@Composable
fun ContactInfo(screenHeightDp: Int, screenWidthDp: Int, model: ProfileScreenViewModel) {

    val telefono = model.phone
    var email = model.email

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height((screenHeightDp * 0.12).dp)   // SCREEN: 12%
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White), // Change color
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = (screenWidthDp * 0.1).dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_telefono), // Replace with your SVG resource ID
                contentDescription = "Universidad de Lima",
                modifier = Modifier.size(25.dp),
                colorFilter = ColorFilter.tint(if (isSystemInDarkTheme()) Color.White else Color.Black),
            )
            if (telefono != null) {
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = telefono, // Add Advanced Text
                    color = if (isSystemInDarkTheme()) White400 else Color.Gray, // Apply the custom text color here
                    fontSize = 15.sp
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = (screenWidthDp * 0.1).dp, top = (screenHeightDp * 0.01).dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_mail), // Replace with your SVG resource ID
                contentDescription = "Universidad de Lima",
                modifier = Modifier.size(25.dp),
                colorFilter = ColorFilter.tint(if (isSystemInDarkTheme()) Color.White else Color.Black),
            )
            if (email != null) {
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = email, // Add Advanced Text
                    color = if (isSystemInDarkTheme()) White400 else Color.Gray, // Apply the custom text color here
                    fontSize = 15.sp
                )
            }
        }
    }
}

@Composable
fun BtnData(screenHeightDp: Int, screenWidthDp: Int){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height((screenHeightDp * 0.09).dp)   // SCREEN: 9%
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White) // Change color
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(2f))
            Button(
                onClick = {},
                modifier = Modifier
                    .height((screenHeightDp * 0.07).dp) // SCREEN: 7%
                    .width((screenWidthDp * 0.75).dp)
                    .background(Orange400)
            ) {
                Text(text = "Actualizar Datos", color = (if (isSystemInDarkTheme()) Color.White else Color.Black)) // Set text color to white
            }
            Spacer(modifier = Modifier.weight(2f))

        }
    }
}

@Composable
fun BtnLogOut(screenHeightDp: Int, screenWidthDp: Int, navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = (screenHeightDp * 0.26).dp) // SCREEN: 26%
            .height((screenHeightDp * 0.9).dp)   // SCREEN: 9%
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White) // Change color
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(2f))
            Button(
                onClick = { navController.navigate("login") },
                modifier = Modifier
                    .height((screenHeightDp * 0.07).dp) // SCREEN: 7%
                    .width((screenWidthDp * 0.75).dp)
                    .background(Orange400),
            ) {
                Text(text = "Cerrar Sesión", color = (if (isSystemInDarkTheme()) Color.White else Color.Black)) // Set text color to white
            }
            Spacer(modifier = Modifier.weight(2f))
        }
    }
}

@Composable
fun FinalScreen(
    screenHeightDp: Int,
    screenWidthDp: Int,
    loginModel: LoginScreenViewModel,
    navController: NavController,
    viewModel: ProfileScreenViewModel) {

    val user = loginModel.user

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White) // Background color, changes in dark mode
    ) {
        TopBar(screenHeightDp, screenWidthDp, navController)
        UserCard(screenHeightDp, screenWidthDp, viewModel)
        ContactInfo(screenHeightDp, screenWidthDp, viewModel)
        BtnData(screenHeightDp, screenWidthDp)
        BtnLogOut(screenHeightDp, screenWidthDp, navController)
    }
}

@Composable
fun ProfileScreen(navController: NavController, loginModel: LoginScreenViewModel, viewModel: ProfileScreenViewModel, userId: Int) {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp
    val screenHeightDp = configuration.screenHeightDp
    viewModel.load(userId)
    FinalScreen(screenHeightDp, screenWidthDp, loginModel, navController, viewModel)
}