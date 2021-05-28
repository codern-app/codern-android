package com.armanco.codern.data.db.dao

import androidx.room.*
import com.armanco.codern.data.model.entity.Element

@Dao
interface ElementDao {
    @Query("SELECT * FROM element")
    suspend fun getAll(): List<Element>

    @Query("SELECT * FROM element WHERE id = :id")
    suspend fun getById(id: String): Element

    @Query("SELECT * FROM element WHERE article_id = :parentId")
    suspend fun getByParent(parentId: String): List<Element>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: Element)

    @Delete
    suspend fun delete(item: Element)

    @Query("DELETE FROM element")
    suspend fun deleteAll()

    @Query("SELECT COUNT(id) FROM element")
    suspend fun getCount(): Int
}