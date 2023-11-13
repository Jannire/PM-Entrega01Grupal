package pe.edu.ulima.pm20232.aulavirtual.models.responses

import com.google.gson.annotations.SerializedName

data class Profile(
    val user_id: Int,
    val user: String,
    val names: String,
    val last_names: String,
    val phone: String,
    val email: String,
    val level_name: String,
    //@SerializedName("image_url")
    //val imageUrl: String
)