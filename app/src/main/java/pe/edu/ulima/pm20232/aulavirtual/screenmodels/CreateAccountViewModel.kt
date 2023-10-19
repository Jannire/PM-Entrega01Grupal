package pe.edu.ulima.pm20232.aulavirtual.screenmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CreateAccountViewModel: ViewModel() {
    var nombre: String by mutableStateOf("")
    var apellido: String by mutableStateOf("")
    var dni: String by mutableStateOf("")
    var correo: String by mutableStateOf("")
    var telefono: String by mutableStateOf("")
    var bottomSheetCollapse: Boolean by mutableStateOf(true)

    fun access(): Unit{
        println("BTN PRESSED")
        println(nombre)
        println(apellido)
        println(dni)
        println(correo)
        println(telefono)
    }
}