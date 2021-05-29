package com.armanco.codern.data.db.dao

import androidx.room.*
import com.armanco.codern.data.model.room.Lesson

@Dao
interface LessonDao {
    @Query("SELECT * FROM lesson")
    suspend fun getAll(): List<Lesson>

    @Query("SELECT * FROM lesson WHERE id = :id")
    suspend fun getById(id: String): Lesson

    @Query("SELECT * FROM lesson WHERE section_id = :parentId")
    suspend fun getByParent(parentId: String): List<Lesson>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: Lesson)

    @Delete
    suspend fun delete(item: Lesson)

    @Query("DELETE FROM lesson")
    suspend fun deleteAll()

    @Query("SELECT COUNT(id) FROM lesson")
    suspend fun getCount(): Int
}