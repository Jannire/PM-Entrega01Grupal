package pe.edu.ulima.pm20232.aulavirtual.models

data class User (
    val id: Int,
    val user: String,
    val password: String,
    val memberId: Int
)