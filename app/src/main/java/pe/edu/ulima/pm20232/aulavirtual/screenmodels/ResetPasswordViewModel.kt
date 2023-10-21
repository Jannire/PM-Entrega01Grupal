package pe.edu.ulima.pm20232.aulavirtual.screenmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ResetPasswordViewModel: ViewModel() {
    var user: String by mutableStateOf("")
    var correo: String by mutableStateOf("")
    var bottomSheetCollapse: Boolean by mutableStateOf(true)

    fun access(): Unit{
        println("BTN PRESSED")
        println(user)
        println(correo)
    }
}