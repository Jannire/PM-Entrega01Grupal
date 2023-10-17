package pe.edu.ulima.pm20232.aulavirtual.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import pe.edu.ulima.pm20232.aulavirtual.configs.TopBarScreen

@Composable
fun TopNavigationBar(navController: NavController, screens: List<TopBarScreen>) {
    var isMenuExpanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(text = "ULima GYM") },
        /*navigationIcon = {
            IconButton(
                onClick = {
                    // Handle navigation icon click (e.g., open drawer or navigate back)
                }
            ) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
            }
        },*/
        actions = {
            IconButton(
                onClick = {
                    isMenuExpanded = true
                }
            ) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Menu"
                )
            }
            DropdownMenu(
                expanded = isMenuExpanded,
                onDismissRequest = { isMenuExpanded = false },
                modifier = Modifier.padding(end = 16.dp)
            ) {
                screens.forEachIndexed { index, item ->
                    DropdownMenuItem(
                        onClick = {
                            isMenuExpanded = false
                            if(item.onClick == null && item.route != null)
                            {
                                navController.navigate(item.route)
                            }else
                            {
                                item.onClick?.let { it() }
                            }

                        }
                    ) {
                        Text(text = item.title)
                    }
                }
            }
        },
    )
}
