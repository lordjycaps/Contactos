package com.example.navegacionentrepantallas.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextButton
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun EditContractScreen(
    contract: Contract, // Recibe el contacto a editar
    onUpdate: (Contract) -> Unit, // Función para actualizar el contacto
    modifier: Modifier = Modifier
) {
    var name by remember { mutableStateOf(contract.name) }
    var numero by remember { mutableStateOf(contract.numero) }
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(50.dp))
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
                onUpdate(Contract(name, numero)) // Actualizar el contrato si ambos campos están llenos
            }
        }) {
            Text("Actualizar Contacto")
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
                text = { Text("Por favor, complete todos los campos antes de actualizar el contacto.") }
            )
        }
    }
}
