package com.example.navegacionentrepantallas.explicacion_clase_Navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable

fun navigationExample(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "screen_a"){
        composable("screen_a"){
            ScreenA(navController)
        }
        composable("screen_b"){
            ScreenB(navController)
        }
    }

}