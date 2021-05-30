package com.armanco.codern.ui.activity.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.armanco.codern.data.repository.local.CourseRepository
import com.armanco.codern.data.repository.local.SectionRepository
import com.armanco.codern.data.repository.remote.ProgressRepository
import com.armanco.codern.data.repository.remote.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val courseRepository: CourseRepository,
    private val sectionRepository: SectionRepository,
    private val userRepository: UserRepository,
    private val progressRepository: ProgressRepository,
): ViewModel() {
    val screen = MutableLiveData<MainScreen>(MainScreen.HomeScreen)
    fun onCreate() {

    }
}