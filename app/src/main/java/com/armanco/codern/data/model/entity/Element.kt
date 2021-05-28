package com.armanco.codern.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.armanco.codern.data.db.converter.ElementTypeConverters
import com.armanco.codern.data.model.ElementType

@Entity
data class Element(
    @PrimaryKey
    val id: String,

    @ColumnInfo(name = "article_id", index = true)
    val articleId: String,

    @ColumnInfo(name = "order_num", index = true)
    val orderNum: Int = 0,

    @ColumnInfo(name = "is_answer")
    val isAnswer: Boolean = false,

    @ColumnInfo(name = "is_choice")
    val isChoice: Boolean = false,

    val content: String? = null,

    @ColumnInfo(name = "element_type")
    @TypeConverters(ElementTypeConverters::class)
    val elementType: ElementType,
)