package com.armanco.codern.data.repository.local

import com.armanco.codern.data.db.dao.CourseDao
import com.armanco.codern.data.db.populate.data.courses.Courses
import com.armanco.codern.data.model.room.Course
import javax.inject.Inject

class CourseRepository @Inject constructor(
    private val courseDao: CourseDao
): DaoInterface<Course> {
    override suspend fun getAll() = courseDao.getAll()
    override suspend fun getById(id: String) = courseDao.getById(id)
    override suspend fun insertAll(vararg items: Course) = courseDao.insertAll(*items)
    override suspend fun delete(item: Course) = courseDao.delete(item)
    override suspend fun deleteAll() = courseDao.deleteAll()
    override suspend fun getCount() = courseDao.getCount()
    suspend fun populate() {
        insertAll(*Courses.populate())
    }
}