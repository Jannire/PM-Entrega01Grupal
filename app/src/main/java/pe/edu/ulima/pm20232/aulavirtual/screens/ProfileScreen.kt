package pe.edu.ulima.pm20232.aulavirtual.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import pe.edu.ulima.pm20232.aulavirtual.R
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Gray800
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Orange400
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Orange800
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.White400
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.White800

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
fun TopBar(screenHeightDp: Int, screenWidthDp: Int) {
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
                .padding(start = (screenWidthDp * 0.05).dp),
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
fun UserCard(screenHeightDp: Int, screenWidthDp: Int, imageUrl: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height((screenHeightDp * 0.20).dp) // SCREEN: 20%
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White)
            .padding(start = (screenWidthDp * 0.1).dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        ImageView(url = imageUrl, width = 100, height = 100) // No adaptability
        Column(
            modifier = Modifier
                .padding(start = (screenWidthDp * 0.08).dp),
        ) {
            Text(
                text = "Andrea Alva",
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = if (isSystemInDarkTheme()) White400 else Color.Black,
                ),
                modifier = Modifier.padding(bottom = (screenHeightDp * 0.01).dp)
            )
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
                    text = "ABAlva",
                    style = TextStyle(
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = if (isSystemInDarkTheme()) White400 else Color.Gray
                    ), modifier = Modifier.padding(start = (screenWidthDp * 0.01).dp)
                )
            }
            Text(
                text = "Estudiante",
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
fun ContactInfo(screenHeightDp: Int, screenWidthDp: Int) {
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
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = "999 888 777", // Add Advanced Text
                color = if (isSystemInDarkTheme()) White400 else Color.Gray, // Apply the custom text color here
                fontSize = 15.sp
            )
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
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = "20210274@aloe.ulima.edu.pe", // Add Advanced Text
                color = if (isSystemInDarkTheme()) White400 else Color.Gray, // Apply the custom text color here
                fontSize = 15.sp
            )
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
fun BtnLogOut(screenHeightDp: Int, screenWidthDp: Int){
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
                onClick = {},
                modifier = Modifier
                    .height((screenHeightDp * 0.07).dp) // SCREEN: 7%
                    .width((screenWidthDp * 0.75).dp)
                    .background(Orange400)
            ) {
                Text(text = "Cerrar Sesión", color = (if (isSystemInDarkTheme()) Color.White else Color.Black)) // Set text color to white
            }
            Spacer(modifier = Modifier.weight(2f))
        }
    }
}

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

@Composable
fun FinalScreen(screenHeightDp: Int, screenWidthDp: Int, imageUrl: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White) // Background color, changes in dark mode
    ) {
        TopBar(screenHeightDp, screenWidthDp)
        UserCard(screenHeightDp, screenWidthDp, imageUrl)
        ContactInfo(screenHeightDp, screenWidthDp)
        BtnData(screenHeightDp, screenWidthDp)
        Activities(screenWidthDp, screenHeightDp)
        BtnLogOut(screenHeightDp, screenWidthDp)
    }
}

@Composable
fun ProfileScreen() {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp
    val screenHeightDp = configuration.screenHeightDp
    val imageUrl =
        "https://wallpapers.com/images/hd/cute-cat-eyes-profile-picture-uq3edzmg1guze2hh.jpg" // Replace with your image URL
    FinalScreen(screenHeightDp, screenWidthDp, imageUrl)
}