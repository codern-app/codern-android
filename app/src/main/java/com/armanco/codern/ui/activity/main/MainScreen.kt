package com.armanco.codern.ui.activity.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.armanco.codern.R

sealed class MainScreen(@StringRes val title: Int, @DrawableRes val icon: Int) {
    object HomeScreen: MainScreen(title = R.string.app_name, icon = R.drawable.ic_icon)
    object ProgressScreen: MainScreen(title = R.string.app_name, icon = R.drawable.ic_icon)
    object ProfileScreen: MainScreen(title = R.string.app_name, icon = R.drawable.ic_icon)
}