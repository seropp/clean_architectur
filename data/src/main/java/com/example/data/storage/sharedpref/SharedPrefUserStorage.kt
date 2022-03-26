package com.example.testapplication.data.storage.sharedpref

import android.content.Context
import com.example.testapplication.data.storage.UserStorage
import com.example.testapplication.data.storage.models.User


private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "first_name"
private const val KEY_LAST_NAME = "last_name"
private const val DEFAULT_FIRST_NAME = "default first name"
private const val DEFAULT_LAST_NAME = "default last name"

class SharedPrefUserStorage(context: Context) : UserStorage {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.userName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, user.userLastName).apply()
        return true
    }

    override fun get(): User {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, DEFAULT_FIRST_NAME) ?: DEFAULT_FIRST_NAME
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_LAST_NAME) ?: DEFAULT_LAST_NAME

        return User(userName = firstName, userLastName = lastName)
    }


}