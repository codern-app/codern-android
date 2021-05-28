package com.armanco.codern.data.db.populate

interface PopulateChild<E>: PopulateMain<E> {
    fun getId(id: String): String
}