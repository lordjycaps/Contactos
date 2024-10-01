package com.example.navegacionentrepantallas.themes

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun themePrincipal(
    appBar: @Composable () -> Unit,
    content: @Composable (PaddingValues) -> Unit,
    onFabClick: () -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            appBar()  // Recibe el appBar como parámetro
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onFabClick) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add Contact")
            }
        }
    ) { innerPadding ->
        content(innerPadding)  // Renderiza el contenido que recibe como parámetro
    }
}
