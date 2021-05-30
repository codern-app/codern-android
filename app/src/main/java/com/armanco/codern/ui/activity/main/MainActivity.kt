package com.armanco.codern.ui.activity.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.BottomNavigation
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.armanco.codern.ui.theme.CodernTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodernTheme {
                Surface(color = MaterialTheme.colors.background) {
                    BottomNavigation {

                    }
                }
            }
        }
    }
}