package com.armanco.codern.data.db.dao

import androidx.room.*
import com.armanco.codern.data.model.entity.Section

@Dao
interface SectionDao {
    @Query("SELECT * FROM section")
    suspend fun getAll(): List<Section>

    @Query("SELECT * FROM section WHERE id = :id")
    suspend fun getById(id: String): Section

    @Query("SELECT * FROM section WHERE course_id = :parentId")
    suspend fun getByParent(parentId: String): List<Section>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: Section)

    @Delete
    suspend fun delete(item: Section)

    @Query("DELETE FROM section")
    suspend fun deleteAll()

    @Query("SELECT COUNT(id) FROM section")
    suspend fun getCount(): Int
}