package com.example.navegacionentrepantallas.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

data class Contract(val name: String, val numero: String)

@Composable
fun RegisterContractScreen(onRegister: (Contract) -> Unit, modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var numero by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre del Contacto") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = numero,
            onValueChange = { newValue ->
                // Filtrar los valores para aceptar solo números
                if (newValue.all { it.isDigit() }) {
                    numero = newValue
                }
            },
            label = { Text("Teléfono") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (name.isEmpty() || numero.isEmpty()) {
                showDialog = true // Mostrar alerta si hay campos vacíos
            } else {
                onRegister(Contract(name, numero)) // Registrar contrato si ambos campos están llenos
            }
        }) {
            Text("Registrar Contacto")
        }

        // Diálogo de alerta
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                confirmButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("OK")
                    }
                },
                title = { Text("Campos vacíos") },
                text = { Text("Por favor, complete todos los campos antes de registrar el contacto.") }
            )
        }
    }
}
