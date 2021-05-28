package com.armanco.codern.data.db.populate

interface PopulateMain<E> {
    fun populate(): Array<E>
}