package com.armanco.codern.data.repository

import com.armanco.codern.data.db.dao.LessonDao
import com.armanco.codern.data.model.entity.Lesson
import javax.inject.Inject

class LessonRepository @Inject constructor(
    private val lessonDao: LessonDao
): Repository<Lesson> {
    override suspend fun getAll() = lessonDao.getAll()
    override suspend fun getById(id: String) = lessonDao.getById(id)
    suspend fun getByParent(parentId: String) = lessonDao.getByParent(parentId)
    override suspend fun insertAll(vararg items: Lesson) = lessonDao.insertAll(*items)
    override suspend fun delete(item: Lesson) = lessonDao.delete(item)
    override suspend fun deleteAll() = lessonDao.deleteAll()
    override suspend fun getCount() = lessonDao.getCount()
    suspend fun populate() {
    }
}