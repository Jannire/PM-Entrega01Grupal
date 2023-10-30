package pe.edu.ulima.pm20232.aulavirtual.screenmodels

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileScreenViewModel: ViewModel() {
    private val _imageUri = MutableStateFlow<String?>(null)
    val imageUri: StateFlow<String?> = _imageUri

    fun setImageUri(uri: Uri?) {
        viewModelScope.launch {
            _imageUri.value = uri.toString()
        }
    }
}
