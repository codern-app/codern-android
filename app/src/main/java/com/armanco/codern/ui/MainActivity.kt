package com.armanco.codern.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.armanco.codern.R
import com.armanco.codern.ui.theme.CodernTheme
import com.armanco.codern.ui.view.Greeting
import com.armanco.codern.utils.extension.log
import com.armanco.codern.utils.facade.AuthFacade
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var authFacade: AuthFacade

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model: MainViewModel by viewModels()
        model.load()
        authFacade.signOut(this)
        authFacade.goToAuth(this)
        setContent {
            CodernTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Greeting(getString(R.string.app_name))
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        authFacade.onAuthResult(requestCode, resultCode, data)
            .addOnSuccessListener {
                log(it)
            }
            .addOnFailureListener {
                log(it.message)
            }
    }
}
