package pe.edu.ulima.pm20232.aulavirtual.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CheckboxWithLabel(
    label: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    disabled: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.padding(16.dp).clickable{
            onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { newChecked ->
                onCheckedChange(newChecked)
            },
            enabled = !disabled,
            //colors = CheckboxDefaults.colors(checkmarkColor = Color.White)
        )
        Text(
            text = label,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}