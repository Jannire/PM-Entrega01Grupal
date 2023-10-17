package pe.edu.ulima.pm20232.aulavirtual.configs

data class TopBarScreen (
    val route: String? = null,
    val title: String,
    val onClick: (() -> Unit)? = null
)