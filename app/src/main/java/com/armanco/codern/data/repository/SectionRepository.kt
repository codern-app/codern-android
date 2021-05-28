package com.armanco.codern.data.repository

import com.armanco.codern.data.db.dao.SectionDao
import com.armanco.codern.data.db.populate.data.sections.Sections
import com.armanco.codern.data.model.entity.Section
import javax.inject.Inject

class SectionRepository @Inject constructor(
    private val sectionDao: SectionDao
): Repository<Section> {
    override suspend fun getAll() = sectionDao.getAll()
    override suspend fun getById(id: String) = sectionDao.getById(id)
    suspend fun getByParent(parentId: String) = sectionDao.getByParent(parentId)
    override suspend fun insertAll(vararg items: Section) = sectionDao.insertAll(*items)
    override suspend fun delete(item: Section) = sectionDao.delete(item)
    override suspend fun deleteAll() = sectionDao.deleteAll()
    override suspend fun getCount() = sectionDao.getCount()
    suspend fun populate() {
        insertAll(*Sections.populate())
    }
}