package com.armanco.codern.ui.component.main

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.armanco.codern.ui.activity.main.MainScreen

@Composable
fun MainBottomNavigation(items: List<MainScreen>, modifier: Modifier, onClickItem: (MainScreen) -> Unit) {
    BottomNavigation(modifier = modifier) {
        items.forEach {
            BottomNavigationItem(
                selected = false,
                onClick = { onClickItem(it) },
                icon = {
                    Icon(
                        painter = painterResource(id = it.icon),
                        contentDescription = ""
                    )
                },
                label = {
                    Text(text = stringResource(it.title))
                }
            )
        }
    }
}