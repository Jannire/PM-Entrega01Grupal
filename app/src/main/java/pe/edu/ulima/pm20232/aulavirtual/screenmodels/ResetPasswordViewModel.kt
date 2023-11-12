package pe.edu.ulima.pm20232.aulavirtual.screenmodels

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import pe.edu.ulima.pm20232.aulavirtual.configs.BackendClient
import pe.edu.ulima.pm20232.aulavirtual.services.UserService
import pe.edu.ulima.pm20232.aulavirtual.services.UserService2

class ResetPasswordViewModel(): ViewModel() {
    var dni: String by mutableStateOf("")
    var correo: String by mutableStateOf("")
    var message: String by mutableStateOf("")
    var bottomSheetCollapse: Boolean by mutableStateOf(true)

    private val userService = BackendClient.buildService(UserService2::class.java)
    private val coroutine: CoroutineScope = viewModelScope

    fun resetPass(): Unit{
        coroutine.launch {
            try {
                withContext(Dispatchers.IO) {
                    val response = userService.resetPass(dni, correo)?.execute()
                    if (response != null) {
                        if (response.body()!!.success == true) {
                            val responseData = response.body()!!
                            message = response.body()!!.message
                        } else {
                            // Maneja errores
                            message = response.body()!!.message
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {

            }
        }
    }

}