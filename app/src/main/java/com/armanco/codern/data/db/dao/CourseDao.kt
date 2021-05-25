package com.armanco.codern.data.db.dao

import androidx.room.*
import com.armanco.codern.data.model.Course

@Dao
interface CourseDao {
    @Query("SELECT * FROM course")
    suspend fun getAll(): List<Course>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg course: Course)

    @Delete
    suspend fun delete(course: Course)

    @Query("DELETE FROM course")
    suspend fun deleteAll()

    @Query("SELECT COUNT(id) FROM course")
    suspend fun getCount(): Int
}