package com.armanco.codern.data.model.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Section(
    @PrimaryKey
    val id: String,

    @ColumnInfo(name = "course_id", index = true)
    val courseId: String,

    @ColumnInfo(name = "order_num", index = true)
    val orderNum: Int = 0,

    val title: String,
    val description: String? = null
)