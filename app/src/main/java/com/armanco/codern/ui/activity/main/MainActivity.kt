package com.armanco.codern.ui.activity.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.lifecycle.ViewModelProvider
import com.armanco.codern.ui.component.main.Home
import com.armanco.codern.ui.component.main.MainBottomNavigation
import com.armanco.codern.ui.component.main.Profile
import com.armanco.codern.ui.component.main.Progress
import com.armanco.codern.ui.theme.CodernTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var model: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProvider(this).get(MainViewModel::class.java)
        setContent {
            val items = listOf(
                MainScreen.HomeScreen,
                MainScreen.ProgressScreen,
                MainScreen.ProfileScreen
            )
            val screen: MainScreen by model.screen.observeAsState(initial = MainScreen.HomeScreen)
            CodernTheme {
                Surface(
                    color = MaterialTheme.colors.background, modifier = Modifier
                        .fillMaxSize()
                ) {
                    val constraints = ConstraintSet {
                        val bottomNav = createRefFor("bottomNav")
                        val frame = createRefFor("frame")
                        constrain(bottomNav) {
                            bottom.linkTo(parent.bottom)
                        }
                        constrain(frame) {
                            top.linkTo(parent.top)
                            bottom.linkTo(bottomNav.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                    }
                    ConstraintLayout(
                        constraintSet = constraints,
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Box(modifier = Modifier.layoutId("frame")) {
                            when(screen) {
                                MainScreen.HomeScreen -> Home()
                                MainScreen.ProgressScreen -> Progress()
                                MainScreen.ProfileScreen -> Profile()
                            }
                        }
                        MainBottomNavigation(
                            items = items,
                            modifier = Modifier.layoutId("bottomNav"),
                            onClickItem = {
                                model.screen.postValue(it)
                            }
                        )
                    }

                }
            }
        }
    }
}