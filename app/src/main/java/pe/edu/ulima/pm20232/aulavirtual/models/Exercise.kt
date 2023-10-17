package pe.edu.ulima.pm20232.aulavirtual.models

data class Exercise(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val videoUrl: String,
    val description: String,
    val bodyPartId: Int,
)
