package com.armanco.codern.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.armanco.codern.R
import com.armanco.codern.ui.theme.CodernTheme
import com.armanco.codern.ui.view.Greeting
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodernTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Greeting(getString(R.string.app_name))
                }
            }
        }
    }
}
