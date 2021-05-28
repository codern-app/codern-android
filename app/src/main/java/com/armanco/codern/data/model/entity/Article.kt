package com.armanco.codern.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Article(
    @PrimaryKey
    val id: String,

    @ColumnInfo(name = "lesson_id", index = true)
    val lessonId: String,

    @ColumnInfo(name = "order_num", index = true)
    val orderNum: Int = 0,
)