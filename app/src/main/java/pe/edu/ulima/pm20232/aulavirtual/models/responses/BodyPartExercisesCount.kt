package pe.edu.ulima.pm20232.aulavirtual.models.responses

import com.google.gson.annotations.SerializedName

data class BodyPartExercisesCount (
    val exercises: Int,
    @SerializedName("body_parts")
    val bodyParts: Int,
)