package com.example.testapplication.data.repository

import com.example.domain.models.SaveUserNameParam
import com.example.domain.models.UserName
import com.example.domain.repository.UserRepository
import com.example.testapplication.data.storage.UserStorage
import com.example.testapplication.data.storage.models.User


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {


    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToStorage(saveParam)
        val result  = userStorage.save(user)
        return result
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToDomain(user: User) : UserName {
        return UserName(firstName = user.userName, lastName = user.userLastName)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam) : User {
        return User(userName = saveParam.name, userLastName =  saveParam.lastName)
    }
}