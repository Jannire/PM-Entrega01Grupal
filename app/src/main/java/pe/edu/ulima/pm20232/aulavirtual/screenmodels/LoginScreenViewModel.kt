package pe.edu.ulima.pm20232.aulavirtual.screenmodels

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import pe.edu.ulima.pm20232.aulavirtual.storage.UserStorage

class LoginScreenViewModel(private val context: Context): ViewModel() {
    var user: String by mutableStateOf("")
    var password: String by mutableStateOf("")
    var bottomSheetCollapse: Boolean by mutableStateOf(true)
    var termsAndConditionsChecked: Boolean by mutableStateOf(false)
    var message: String by mutableStateOf("")

    private val userService = BackendClient.buildService(UserService2::class.java)
    private val coroutine: CoroutineScope = viewModelScope
    val dataStore = UserStorage(context)

    fun access(navController: NavController): Unit{
        println("BTN PRESSED$user :: $password")
        coroutine.launch {
            try {
                withContext(Dispatchers.IO) {
                    val response = userService.findOne(user, password)?.execute()
                    if (response != null) {
                        if (response.body()!!.success) {
                            val responseData = response.body()!!
                            val jsonData = JSONObject(responseData.data)
                            val userId = jsonData.getInt("user_id")
                            val memberId = jsonData.getInt("member_id")
                            println("RESPUESTA : "+ response.body())
                            // localstorage
                            dataStore.saveUserId(userId)
                            println("routine?user_id=${userId}&member_id=${memberId}")
                            launch(Dispatchers.Main) {
                                navController.navigate("routine?user_id=${userId}&member_id=${memberId}")
                            }
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