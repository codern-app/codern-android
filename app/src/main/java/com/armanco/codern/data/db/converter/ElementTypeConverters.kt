package com.armanco.codern.data.db.converter

import androidx.room.TypeConverter
import com.armanco.codern.data.model.ElementType

class ElementTypeConverters {

    @TypeConverter
    fun toElementType(value: Int) = enumValues<ElementType>()[value]

    @TypeConverter
    fun fromElementType(value: ElementType) = value.ordinal

}