package com.armanco.codern.ui.activity.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.armanco.codern.data.model.firestore.Progress
import com.armanco.codern.data.model.firestore.User
import com.armanco.codern.data.repository.local.CourseRepository
import com.armanco.codern.data.repository.local.SectionRepository
import com.armanco.codern.data.repository.remote.ProgressRepository
import com.armanco.codern.data.repository.remote.UserRepository
import com.armanco.codern.utils.facade.AuthFacade
import com.google.firebase.Timestamp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val courseRepository: CourseRepository,
    private val sectionRepository: SectionRepository,
    private val userRepository: UserRepository,
    private val progressRepository: ProgressRepository,
): ViewModel() {
    val user = MutableLiveData<User>()
    val isReady = MutableLiveData(false)

    fun onCreate() {
        viewModelScope.launch {
            isReady.postValue(false)
            populate()
            isReady.postValue(true)
        }
    }

    private suspend fun populate() {
        courseRepository.deleteAll()
        courseRepository.populate()
        sectionRepository.deleteAll()
        sectionRepository.populate()
    }

    fun updateUser(user: User) {
        this.user.postValue(user)
        userRepository.set(user)
    }
}