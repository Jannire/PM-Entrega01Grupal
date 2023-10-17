package pe.edu.ulima.pm20232.aulavirtual

import android.R
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.AulaVirtualTheme


class AdminActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val intent = intent
        val extras = intent.extras
        if (extras != null) {
            // Retrieve values from the Intent's extras
            val param1 = extras.getString("key")
            Log.d("ADMIN ACTIVITY", param1.toString())
        }

        super.onCreate(savedInstanceState)
        setContent {
            AulaVirtualTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Text("Admin")
                }
            }
            val context = LocalContext.current
            val currentActivity = (context as? ComponentActivity)
            BackHandler {
                Log.d("ADMIN ACTIVITY", "BackHandler")
                currentActivity?.let {
                    it.finishAffinity() // Finish the current activity and all associated activities
                }
            }
        }
    }
}