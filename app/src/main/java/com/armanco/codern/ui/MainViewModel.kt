package com.armanco.codern.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.armanco.codern.data.repository.CourseRepository
import com.armanco.codern.data.repository.SectionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val courseRepository: CourseRepository,
    private val sectionRepository: SectionRepository
): ViewModel() {

    fun load() {
        viewModelScope.launch {
            courseRepository.deleteAll()
            courseRepository.populate()
            sectionRepository.deleteAll()
            sectionRepository.populate()
            Log.d("test", courseRepository.getAll().getOrNull(0)?.title.orEmpty())
        }
    }
}