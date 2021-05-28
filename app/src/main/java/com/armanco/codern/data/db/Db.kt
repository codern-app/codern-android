package com.armanco.codern.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.armanco.codern.data.db.dao.*
import com.armanco.codern.data.model.entity.*

@Database(
    entities = [
        Course::class,
        Section::class,
        Lesson::class,
        Article::class,
        Element::class
    ], version = 1
)
abstract class Db : RoomDatabase() {
    abstract fun courseDao(): CourseDao
    abstract fun sectionDao(): SectionDao
    abstract fun lessonDao(): LessonDao
    abstract fun articleDao(): ArticleDao
    abstract fun elementDao(): ElementDao
}