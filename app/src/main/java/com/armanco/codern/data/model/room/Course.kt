package com.armanco.codern.data.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Course(
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String? = null
)