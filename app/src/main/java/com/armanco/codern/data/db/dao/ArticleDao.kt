package com.armanco.codern.data.db.dao

import androidx.room.*
import com.armanco.codern.data.model.room.Article

@Dao
interface ArticleDao {
    @Query("SELECT * FROM article")
    suspend fun getAll(): List<Article>

    @Query("SELECT * FROM article WHERE id = :id")
    suspend fun getById(id: String): Article

    @Query("SELECT * FROM article WHERE lesson_id = :parentId")
    suspend fun getByParent(parentId: String): List<Article>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: Article)

    @Delete
    suspend fun delete(item: Article)

    @Query("DELETE FROM article")
    suspend fun deleteAll()

    @Query("SELECT COUNT(id) FROM article")
    suspend fun getCount(): Int
}