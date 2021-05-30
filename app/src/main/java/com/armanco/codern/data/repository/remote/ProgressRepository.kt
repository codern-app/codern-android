package com.armanco.codern.data.repository.remote

import com.armanco.codern.data.model.firestore.Progress
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import javax.inject.Inject

class ProgressRepository @Inject constructor(
    private val firestore: FirebaseFirestore
) {
    fun add(userId: String, courseId: String): Task<Void> {
        return firestore.collection(UserRepository.COLLECTION).document(userId)
            .collection(COLLECTION).document(courseId)
            .set(mapOf<String, String>(), SetOptions.merge())
    }

    fun set(userId: String, progress: Progress): Task<Void> {
        return firestore.collection(UserRepository.COLLECTION).document(userId)
            .collection(COLLECTION).document(progress.courseId)
            .set(progress.toMapRemoveNull(), SetOptions.merge())
    }

    fun get(userId: String, courseId: String): Task<DocumentSnapshot> {
        return firestore.collection(UserRepository.COLLECTION).document(userId)
            .collection(COLLECTION).document(courseId)
            .get()
    }

    companion object {
        const val COLLECTION = "progresses"
    }
}