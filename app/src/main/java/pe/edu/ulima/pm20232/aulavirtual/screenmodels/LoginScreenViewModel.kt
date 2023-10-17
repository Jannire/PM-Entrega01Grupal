package pe.edu.ulima.pm20232.aulavirtual.screenmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import pe.edu.ulima.pm20232.aulavirtual.services.UserService


class LoginScreenViewModel: ViewModel() {
    var user: String by mutableStateOf("")
    var password: String by mutableStateOf("")
    var bottomSheetCollapse: Boolean by mutableStateOf(true)
    var termsAndConditionsChecked: Boolean by mutableStateOf(false)
    var message: String by mutableStateOf("")

    fun access(navController: NavController): Unit{
        println("BTN PRESSED")
        println(user)
        println(password)
        if(user == "admin" && password == "123"){
            navController.navigate("profile")
        }else{
            val userService: UserService = UserService()
            val userId = userService.checkUser(user, password)
            if(userId != 0){
                navController.navigate("home?user_id=${userId}")
            }else{
                message = "Usuario y contraseña no coinciden"
            }
        }
    }
}