package pe.edu.ulima.pm20232.aulavirtual.configs

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomBarScreen (
    val route: String? = null,
    val title: String,
    val icon: ImageVector,
    val onClick: (() -> Unit)? = null
)