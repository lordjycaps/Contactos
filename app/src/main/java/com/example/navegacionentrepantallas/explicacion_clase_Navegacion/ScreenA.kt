package com.example.navegacionentrepantallas.explicacion_clase_Navegacion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController

@Composable
fun ScreenA(navController: NavController){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       Text(text = "Pantalla A")
        Button(onClick = { navController.navigate("screen_b")}) {
            Text(text = "Ir a pantalla B")
        }
    }
}