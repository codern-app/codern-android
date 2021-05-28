package com.armanco.codern.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Lesson(
    @PrimaryKey
    val id: String,

    @ColumnInfo(name = "section_id", index = true)
    val sectionId: String,

    @ColumnInfo(name = "order_num", index = true)
    val orderNum: Int = 0,

    val title: String,
    val description: String? = null
)