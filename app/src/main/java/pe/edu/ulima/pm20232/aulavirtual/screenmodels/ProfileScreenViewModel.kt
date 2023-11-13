package pe.edu.ulima.pm20232.aulavirtual.screenmodels

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.ulima.pm20232.aulavirtual.R
import pe.edu.ulima.pm20232.aulavirtual.configs.BackendClient
import pe.edu.ulima.pm20232.aulavirtual.screens.ImageView
import pe.edu.ulima.pm20232.aulavirtual.services.MemberService
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.White400

class ProfileScreenViewModel: ViewModel() {
    private val _imageUri = MutableStateFlow<String?>(null)
    private val memberService = BackendClient.buildService(MemberService::class.java)
    private val coroutine: CoroutineScope = viewModelScope
    val imageUri: StateFlow<String?> = _imageUri

    var lname: String by mutableStateOf("")
    var name: String by mutableStateOf("")
    var phone: String by mutableStateOf("")
    var email: String by mutableStateOf("")
    var level: String by mutableStateOf("")
    var img: String by mutableStateOf("")

    fun setImageUri(uri: Uri?) {
        viewModelScope.launch {
            _imageUri.value = uri.toString()
        }
    }

    fun load(user: Int){
        coroutine.launch {
            try {
                withContext(Dispatchers.IO) {
                    val response = memberService.profile(user)?.execute()
                    if (response != null) {
                        lname = response.body()!!.last_names
                        name = response.body()!!.names
                        phone = response.body()!!.phone
                        email = response.body()!!.email
                        level = response.body()!!.level_name
                        //img = response.body()!!.imageUrl

                    println("RESPUESTA : " + response.body())

                } else {
                    // Maneja errores
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {

            }
        }
    }

}
