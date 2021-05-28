package com.armanco.codern.data.db.dao

import androidx.room.*
import com.armanco.codern.data.model.entity.Course

@Dao
interface CourseDao {
    @Query("SELECT * FROM course")
    suspend fun getAll(): List<Course>

    @Query("SELECT * FROM course WHERE id = :id")
    suspend fun getById(id: String): Course

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: Course)

    @Delete
    suspend fun delete(item: Course)

    @Query("DELETE FROM course")
    suspend fun deleteAll()

    @Query("SELECT COUNT(id) FROM course")
    suspend fun getCount(): Int
}