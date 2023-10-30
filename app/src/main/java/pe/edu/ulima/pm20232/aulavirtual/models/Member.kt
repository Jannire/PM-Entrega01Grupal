package pe.edu.ulima.pm20232.aulavirtual.models

data class Member (
    val id: Int,
    val code: Int,
    val names: String,
    val lastNames: String,
    val email: String,
    val phone: String,
    val imageUrl: String,
    val levelId: Int,
    val dni: String,
)