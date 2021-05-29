package com.armanco.codern.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.lifecycle.ViewModelProvider
import com.armanco.codern.R
import com.armanco.codern.data.model.firestore.User
import com.armanco.codern.ui.theme.CodernTheme
import com.armanco.codern.ui.view.Greeting
import com.armanco.codern.utils.extension.log
import com.armanco.codern.utils.facade.AuthFacade
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var model: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProvider(this).get(MainViewModel::class.java)
        model.load()
        if(!AuthFacade.isLoggedIn) {
            AuthFacade.goToAuth(this)
        } else {
            AuthFacade.user?.let { model.addUser(User.fromFirebaseUser(it)) }
        }
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
        AuthFacade.onAuthResult(requestCode, resultCode, data)
            .addOnSuccessListener {
                model.addUser(User.fromFirebaseUser(it))
            }
            .addOnFailureListener {
                log(it.message)
            }
    }
}
