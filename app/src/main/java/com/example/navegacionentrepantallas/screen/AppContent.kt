package com.example.navegacionentrepantallas.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.navegacionentrepantallas.themes.themePrincipal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent() {
    var showRegister by remember { mutableStateOf(false) }
    var contracts by remember { mutableStateOf(listOf<Contract>()) }
    var contractToEdit by remember { mutableStateOf<Contract?>(null) }

    if (showRegister) {
        themePrincipal(
            appBar = {
                TopAppBar(
                    title = { Text("Registrar Contacto") },
                    navigationIcon = {
                        IconButton(onClick = { showRegister = false }) {
                            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),

                    )
            },
            content = { padding ->
                RegisterContractScreen(
                    onRegister = { contract ->
                        contracts = contracts + contract
                        showRegister = false
                    },
                    modifier = Modifier.padding(padding)
                )
            },
            onFabClick = {}
        )
    } else {
        themePrincipal(
            appBar = {
                TopAppBar(
                    title = { Text("Mis Contactos") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                )
            },
            content = { padding ->
                if (contractToEdit == null) {
                    // Pantalla para ver los contactos
                    ViewContractsScreen(
                        contracts = contracts,
                        onEdit = { contract -> contractToEdit = contract }, // Al hacer clic en editar, se muestra la pantalla de edición
                        onDelete = { contract ->
                            contracts = contracts - contract // Eliminar el contacto
                        }
                    )
                } else {
                    // Pantalla para editar el contacto
                    EditContractScreen(
                        contract = contractToEdit!!,
                        onUpdate = { updatedContract ->
                            // Actualizar el contacto en la lista
                            contracts = contracts.map {
                                if (it == contractToEdit) updatedContract else it
                            }
                            contractToEdit = null // Volver a la vista de contactos
                        }
                    )
                }
            },
            onFabClick = { showRegister = true }  // Redirige al registro de contactos
        )
    }
}

