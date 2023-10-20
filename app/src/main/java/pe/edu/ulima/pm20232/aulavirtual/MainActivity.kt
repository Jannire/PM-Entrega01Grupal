package pe.edu.ulima.pm20232.aulavirtual

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import pe.edu.ulima.pm20232.aulavirtual.components.BottomNavigationBar
import pe.edu.ulima.pm20232.aulavirtual.components.TopNavigationBar
import pe.edu.ulima.pm20232.aulavirtual.configs.AlertDialogExample
import pe.edu.ulima.pm20232.aulavirtual.configs.BottomBarScreen
import pe.edu.ulima.pm20232.aulavirtual.configs.TopBarScreen
import pe.edu.ulima.pm20232.aulavirtual.screenmodels.CreateAccountViewModel
import pe.edu.ulima.pm20232.aulavirtual.screenmodels.LoginScreenViewModel
import pe.edu.ulima.pm20232.aulavirtual.screenmodels.ProfileScreenViewModel
import pe.edu.ulima.pm20232.aulavirtual.screenmodels.HomeScreenViewModel
import pe.edu.ulima.pm20232.aulavirtual.screenmodels.ResetPasswordViewModel
import pe.edu.ulima.pm20232.aulavirtual.screenmodels.ExerciseScreenViewModel
import pe.edu.ulima.pm20232.aulavirtual.screens.*
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.AulaVirtualTheme
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.White400

class MainActivity : ComponentActivity() {
    private val loginScreenViewModel by viewModels<LoginScreenViewModel>()
    private val profileScreenViewModel by viewModels<ProfileScreenViewModel>()
    private val homeScreenViewModel by viewModels<HomeScreenViewModel>()
    private val resetScreenViewModel by viewModels<ResetPasswordViewModel>()
    private val createAccountViewModel by viewModels<CreateAccountViewModel>()
    private val exerciseScreenViewModel by viewModels<ExerciseScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AulaVirtualTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val blackList: List<String> = listOf("profile", "login")
                    val currentRoute = navBackStackEntry?.destination?.route
                    var showDialogShare by remember { mutableStateOf(false) }
                    var showDialogAbout by remember { mutableStateOf(false) }
                    Scaffold(
                        topBar = {
                            if(!blackList.contains(currentRoute)) {
                                val screens: List<TopBarScreen> = listOf(
                                    TopBarScreen(
                                        route = "profile",
                                        title = "Editar perfil",
                                    ),
                                    TopBarScreen(
                                        title = "Acerca de",
                                        onClick = {
                                            showDialogAbout = true;
                                        }
                                    ),
                                    TopBarScreen(
                                        route = "sign_out",
                                        title = "Cerrar Sesión",
                                    ),
                                )
                                TopNavigationBar(navController, screens)
                            }
                        },
                        bottomBar = {
                            if(!blackList.contains(currentRoute)) {
                                val screens: List<BottomBarScreen> = listOf(
                                    BottomBarScreen(
                                        route = "home",
                                        title = "Mi rutina",
                                        icon = Icons.Default.Home
                                    ),
                                    BottomBarScreen(
                                        route = "exercises",
                                        title = "Ejercicios",
                                        icon = Icons.Default.List
                                    ),
                                    BottomBarScreen(
                                        title = "Compartir",
                                        icon = Icons.Default.Settings,
                                        onClick = {
                                            showDialogShare = true;
                                        }
                                    ),
                                )
                                BottomNavigationBar(navController = navController, screens)
                            }
                        },
                        content = {
                            if (showDialogShare) {
                                AlertDialog(
                                    onDismissRequest = {
                                        showDialogShare = false
                                    },
                                    title = {
                                        Text(text = "Gracias por compartir", textAlign = TextAlign.Center)
                                    },
                                    text = {
                                        val imageUrlWhats = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/WhatsApp.svg/512px-WhatsApp.svg.png"
                                        val uriWhats = Uri.parse(imageUrlWhats)
                                        val painterWhats = rememberImagePainter(
                                            data = uriWhats.scheme + "://" + uriWhats.host + uriWhats.path + (if (uriWhats.query != null) uriWhats.query else ""),
                                            builder = {
                                                // You can apply transformations here if needed
                                                transformations(CircleCropTransformation())
                                            }
                                        )
                                        val imageUrlGit = "https://cdn-icons-png.flaticon.com/512/25/25231.png"
                                        val uriGit = Uri.parse(imageUrlGit)
                                        val painterGit = rememberImagePainter(
                                            data = uriGit.scheme + "://" + uriGit.host + uriGit.path + (if (uriGit.query != null) uriGit.query else ""),
                                            builder = {
                                                // You can apply transformations here if needed
                                                transformations(CircleCropTransformation())
                                            }
                                        )
                                        Column(){
                                            Row(){
                                                Box(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .weight(4f)
                                                )
                                                Image(
                                                    painter = painterWhats,
                                                    contentDescription = "Whatsapp", // Set a proper content description if required
                                                    modifier = Modifier.size(40.dp, 40.dp)
                                                )
                                                Box(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .weight(2f)
                                                )
                                                Image(
                                                    painter = painterGit,
                                                    contentDescription = "GitHub", // Set a proper content description if required
                                                    modifier = Modifier.size(40.dp, 40.dp)
                                                )
                                                Box(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .weight(4f)
                                                )
                                            }
                                        }
                                    },
                                    confirmButton = {
                                        TextButton(
                                            onClick = {
                                                // Lógica para manejar el botón de confirmación
                                                showDialogShare = false
                                            }
                                        ) {
                                            Text("Aceptar")
                                        }
                                    },
                                    dismissButton = {
                                        TextButton(
                                            onClick = {
                                                // Lógica para manejar el botón de descartar
                                                showDialogShare = false
                                            }
                                        ) {
                                            Text("Cancelar")
                                        }
                                    }
                                )
                            }
                            if (showDialogAbout)
                            {
                                AlertDialog(
                                    onDismissRequest = {
                                        showDialogAbout = false
                                    },
                                    title = {
                                        Text(text = "Título del cuadro de diálogo")
                                    },
                                    text = {
                                        val imageUrl = "https://pokefanaticos.com/pokedex/assets/images/pokemon_imagenes/25.png"
                                        val uri = Uri.parse(imageUrl)
                                        val painter = rememberImagePainter(
                                            data = uri.scheme + "://" + uri.host + uri.path + (if (uri.query != null) uri.query else ""),
                                            builder = {
                                                // You can apply transformations here if needed
                                                transformations(CircleCropTransformation())
                                            }
                                        )
                                        Column(){
                                            Text("Este es un cuadro de diálogo de alerta en Compose. Puedes personalizar su contenido aquí.")
                                            Row(){
                                                Image(
                                                    painter = painter,
                                                    contentDescription = null, // Set a proper content description if required
                                                    modifier = Modifier.size(40.dp, 40.dp)
                                                )
                                                Image(
                                                    painter = painter,
                                                    contentDescription = null, // Set a proper content description if required
                                                    modifier = Modifier.size(40.dp, 40.dp)
                                                )
                                            }
                                        }
                                    },
                                    confirmButton = {
                                        TextButton(
                                            onClick = {
                                                // Lógica para manejar el botón de confirmación
                                                showDialogAbout = false
                                            }
                                        ) {
                                            Text("Aceptar")
                                        }
                                    },
                                    dismissButton = {
                                        TextButton(
                                            onClick = {
                                                // Lógica para manejar el botón de descartar
                                                showDialogAbout = false
                                            }
                                        ) {
                                            Text("Cancelar")
                                        }
                                    }
                                )
                            }

                            NavHost(navController, startDestination = "login") {
                                composable(route = "splash") {
                                    SplashScreen {
                                        navController.navigate("login")
                                    }
                                }
                                composable(route = "home") {
                                    Log.d("HOME", "home screen")
                                    HomeScreen(navController,LoginScreenViewModel(), homeScreenViewModel)
                                }
                                composable(route = "reset_password") {
                                    Log.d("ROUTER", "reset password")
                                    ResetPasswordScreen(navController, resetScreenViewModel)
                                }
                                composable(route = "profile") {
                                    Log.d("ROUTER", "profile")
                                    ProfileScreen(navController, profileScreenViewModel)
                                }
                                composable(route = "login") {
                                    Log.d("ROUTER", "login")
                                    LoginScreen(loginScreenViewModel, navController)
                                }
                                composable(route = "create_account") {
                                    Log.d("ROUTER", "create account")
                                    CreateAccountScreen(createAccountViewModel, navController)
                                }
                                composable(route = "exercises") {
                                    Log.d("EXERCISES", "exercises screen")
                                    ExerciseScreen(navController, exerciseScreenViewModel)
                                }
                                // Cambiar rutas para el detalle de cada ejercicio:
                                /*
                                composable(route = "pokemon/edit?pokemon_id={pokemon_id}", arguments = listOf(
                                    navArgument("pokemon_id") {
                                        type = NavType.IntType
                                        defaultValue = 0
                                    }
                                ), content = { entry ->
                                    val pokemonId = entry.arguments?.getInt("pokemon_id")!!
                                    pokemonDetailScreenViewModel.pokemonId = pokemonId
                                    PokemonDetailScreen(navController, pokemonDetailScreenViewModel)
                                })
                                 */
                            }
                        }
                    )

                }
            }
        }
    }
}
