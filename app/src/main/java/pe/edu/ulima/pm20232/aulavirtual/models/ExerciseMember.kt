package pe.edu.ulima.pm20232.aulavirtual.models

data class ExerciseMember (
    val id: Int,
    val reps: Int,
    val sets: Int,
    val exerciseId: Int,
    val memberId: Int,
    )