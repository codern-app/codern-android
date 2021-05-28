package com.armanco.codern.data.repository

interface Repository<E> {
    suspend fun getAll(): List<E>
    suspend fun getById(id: String): E
    suspend fun insertAll(vararg items: E)
    suspend fun delete(item: E)
    suspend fun deleteAll()
    suspend fun getCount(): Int
}