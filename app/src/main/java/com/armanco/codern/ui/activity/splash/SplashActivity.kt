package com.armanco.codern.ui.activity.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.armanco.codern.R
import com.armanco.codern.data.model.firestore.User
import com.armanco.codern.ui.activity.main.MainActivity
import com.armanco.codern.ui.theme.CodernTheme
import com.armanco.codern.utils.extension.log
import com.armanco.codern.utils.facade.AuthFacade
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : ComponentActivity() {

    private lateinit var model: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProvider(this).get(SplashViewModel::class.java)
        model.onCreate()
        model.isReady.observe(this) { isReady ->
            if (isReady) {
                if (!AuthFacade.isLoggedIn) {
                    AuthFacade.goToAuth(this)
                } else {
                    AuthFacade.user?.let { model.updateUser(User.fromFirebaseUser(it)) }
                    goToMain()
                }
            }
        }
        setContent {
            CodernTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_icon),
                            contentDescription = "",
                            modifier = Modifier
                                .background(MaterialTheme.colors.primary)
                                .width(80.dp)
                                .height(80.dp)
                        )
                        CircularProgressIndicator(
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp),
                            strokeWidth = 2.dp
                        )
                    }
                }
            }
        }
    }

    private fun goToMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        AuthFacade.onAuthResult(requestCode, resultCode, data)
            .addOnSuccessListener {
                model.updateUser(User.fromFirebaseUser(it))
                goToMain()
            }
            .addOnFailureListener {
                log(it.message)
            }
    }
}
