package pe.edu.ulima.pm20232.aulavirtual.screenmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pe.edu.ulima.pm20232.aulavirtual.configs.BackendClient
import pe.edu.ulima.pm20232.aulavirtual.services.UserService2

class CreateAccountViewModel: ViewModel() {
    var nombre: String by mutableStateOf("")
    var apellido: String by mutableStateOf("")
    var dni: String by mutableStateOf("")
    var correo: String by mutableStateOf("")
    var telefono: String by mutableStateOf("")
    var contrasena: String by mutableStateOf("")
    var repContrasena: String by mutableStateOf("")
    var bottomSheetCollapse: Boolean by mutableStateOf(true)
    var message: String by mutableStateOf("")

    private val userService = BackendClient.buildService(UserService2::class.java)
    private val coroutine: CoroutineScope = viewModelScope

    fun access(): Unit {
        println("BTN PRESSED")
        coroutine.launch {
            try {
                // Verificar que todos los campos estén llenos
                if (nombre.isNotBlank() && apellido.isNotBlank() && dni.isNotBlank() &&
                    correo.isNotBlank() && telefono.isNotBlank() && contrasena.isNotBlank() &&
                    repContrasena.isNotBlank()
                ) {

                    // Verificar la estructura del correo
                    val emailRegex = Regex("[0-9]+@aloe.ulima.edu.pe")
                    if (emailRegex.matches(correo)) {

                        // Verificar duplicidad de DNI y correo en el backend
                        withContext(Dispatchers.IO) {
                            try {
                                val response = userService.createAccount(dni, correo)?.execute()
                                if (response != null) {
                                    if (response.body()?.success == true) {
                                        //val body = response.body()!!
                                        //val codigo = correo.substringBefore('@')
                                        println("Usuario creado exitosamente")
                                        message = "Cuenta creada correctamente."
                                    } else {
                                        message = response.body()?.message
                                            ?: "Error en la respuesta del servidor"
                                    }
                                }
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }

                    } else {
                        message = "El correo debe seguir la estructura [código]@aloe.ulima.edu.pe"
                    }
                } else {
                    message = "Todos los campos son obligatorios"
                }

            } catch (e: Exception) {
                e.printStackTrace()
            } finally {}
        }
    }
}