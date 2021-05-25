package com.armanco.codern.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.armanco.codern.data.db.dao.CourseDao
import com.armanco.codern.data.model.Course

@Database(
    entities = [
        Course::class
    ], version = 1
)
abstract class Db : RoomDatabase() {
    abstract fun courseDao(): CourseDao
}