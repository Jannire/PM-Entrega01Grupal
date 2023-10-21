package pe.edu.ulima.pm20232.aulavirtual.models

data class Member (
    val id: Int,
    val code: Int,
<<<<<<< Updated upstream
=======
    val dni: String,
>>>>>>> Stashed changes
    val names: String,
    val lastNames: String,
    val email: String,
    val phone: String,
    val imageUrl: String,
<<<<<<< Updated upstream
    val levelId: Int,
    val dni: String,
=======
    val levelId: Int
>>>>>>> Stashed changes
)