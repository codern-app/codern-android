package com.armanco.codern.data.model.firestore

data class User(
    val userId: String,
    var name: String? = null,
    var email: String? = null,
    var photoUrl: String? = null,
    val emailVerified: Boolean? = null,
    var phoneNumber: String? = null,
    var xp: Int? = null,
) {
    fun toMapRemoveNull(): Map<String, Any> {
        val hashMap = hashMapOf<String, Any>()
        hashMap[USER_ID] = userId
        name?.let { hashMap[NAME] = it }
        email?.let { hashMap[EMAIL] = it }
        photoUrl?.let { hashMap[PHOTO_URL] = it }
        emailVerified?.let { hashMap[EMAIL_VERIFIED] = it }
        phoneNumber?.let { hashMap[PHONE_NUMBER] = it }
        xp?.let { if(it>0) hashMap[XP] = it }
        return hashMap
    }

    companion object {
        const val USER_ID = "userId"
        const val NAME = "name"
        const val EMAIL = "email"
        const val PHOTO_URL = "photoUrl"
        const val EMAIL_VERIFIED = "emailVerified"
        const val PHONE_NUMBER = "phoneNumber"
        const val XP = "xp"
    }
}