package com.example.testapplication.data.storage

import com.example.testapplication.data.storage.models.User

interface UserStorage {

    fun save(saveParam: User): Boolean

    fun get(): User
}