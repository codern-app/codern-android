package com.armanco.codern.data.repository

import com.armanco.codern.data.db.dao.CourseDao
import com.armanco.codern.data.model.Course
import javax.inject.Inject

class CourseRepository @Inject constructor(
    private val courseDao: CourseDao
){
    suspend fun getAll() = courseDao.getAll()
    suspend fun insertAll(vararg course: Course) = courseDao.insertAll(*course)
    suspend fun delete(course: Course) = courseDao.delete(course)
    suspend fun deleteAll() = courseDao.deleteAll()
    suspend fun getCount() = courseDao.getCount()
}