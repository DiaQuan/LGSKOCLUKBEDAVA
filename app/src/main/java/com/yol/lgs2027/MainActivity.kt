package com.yol.lgs2027

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.yol.lgs2027.navigation.YolNavGraph
import com.yol.lgs2027.ui.theme.YolTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YolTheme {
                YolNavGraph()
            }
        }
    }
}
