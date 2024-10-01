package com.example.navegacionentrepantallas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.navegacionentrepantallas.screen.AppContent

import com.example.navegacionentrepantallas.ui.theme.NavegacionEntrePantallasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavegacionEntrePantallasTheme {
                AppContent()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NavegacionEntrePantallasTheme {
        AppContent()
    }
}
