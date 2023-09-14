package pe.edu.ulima.pm20232.aulavirtual.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Orange400

@Composable
fun ButtonWithIcon(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier? = Modifier.fillMaxWidth().height(55.dp),
    backgroundColor: Color? = Orange400
) {
    Button(
        onClick = { onClick() },
        modifier = modifier!!,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor!!, // Button background color
            contentColor = Color.White // Text and icon color
        ),
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 20.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = text)
        }
    }
}