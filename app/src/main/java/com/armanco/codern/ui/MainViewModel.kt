package com.armanco.codern.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.armanco.codern.data.model.firestore.Progress
import com.armanco.codern.data.model.firestore.User
import com.armanco.codern.data.repository.local.CourseRepository
import com.armanco.codern.data.repository.local.SectionRepository
import com.armanco.codern.data.repository.remote.ProgressRepository
import com.armanco.codern.data.repository.remote.UserRepository
import com.google.firebase.Timestamp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val courseRepository: CourseRepository,
    private val sectionRepository: SectionRepository,
    private val userRepository: UserRepository,
    private val progressRepository: ProgressRepository,
): ViewModel() {
    val user = MutableLiveData<User>()

    fun load() {
        viewModelScope.launch {
            courseRepository.deleteAll()
            courseRepository.populate()
            sectionRepository.deleteAll()
            sectionRepository.populate()
            Log.d("test", courseRepository.getAll().getOrNull(0)?.title.orEmpty())
        }
    }

    fun addUser(user: User) {
        this.user.postValue(user)
        userRepository.set(user)
        progressRepository.set(user.userId, Progress(
            courseId = "html",
            startDate = Timestamp.now(),
        )
        )
    }
}