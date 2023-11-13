package pe.edu.ulima.pm20232.aulavirtual.models.responses

import com.google.gson.annotations.SerializedName

data class ExerciseSetReps(
    val id: Int,
    val name: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("video_url")
    val videoUrl: String,
    val description: String,
    val sets: Int,
    val reps: Int,
)