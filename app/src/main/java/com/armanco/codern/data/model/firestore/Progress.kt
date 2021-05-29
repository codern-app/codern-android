package com.armanco.codern.data.model.firestore

import com.google.firebase.Timestamp

data class Progress (
    val courseId: String,
    var startDate: Timestamp? = null,
    var endDate: Timestamp? = null,
    var finished: Boolean? = null,
    var sections: MutableList<String>? = null,
    var lessons: MutableList<String>? = null,
) {
    fun toMapRemoveNull(): Map<String, Any> {
        val hashMap = hashMapOf<String, Any>()
        hashMap[COURSE_ID] = courseId
        startDate?.let { hashMap[START_DATE] = it }
        endDate?.let { hashMap[END_DATE] = it }
        finished?.let { hashMap[FINISHED] = it }
        sections?.let { if(it.isNotEmpty()) hashMap[SECTIONS] = it }
        lessons?.let { if(it.isNotEmpty()) hashMap[LESSONS] = it }
        return hashMap
    }

    companion object {
        const val COURSE_ID = "courseId"
        const val START_DATE = "startDate"
        const val END_DATE = "endDate"
        const val FINISHED = "finished"
        const val SECTIONS = "sections"
        const val LESSONS = "lessons"
    }
}