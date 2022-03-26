package com.example.testapplication.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.SaveUserNameParam
import com.example.domain.models.UserName
import com.example.domain.usecase.GetUserNameUseCase
import com.example.domain.usecase.SaveUserNameUseCase
import com.example.testapplication.data.storage.models.User

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    var resultLiveData = MutableLiveData<String>()


    init {
        Log.e("AAA", "VM created _______________________________")
    }

    override fun onCleared() {
        Log.e("AAA", "VM cleared _______________________________")
        super.onCleared()
    }

    fun save(textName: String, textLastName: String) {
        val params = SaveUserNameParam(name = textName, lastName = textLastName)
        val result: Boolean = saveUserNameUseCase.execute(param = params)
    }

    fun load() {
        val userName: UserName = getUserNameUseCase.execute()

        resultLiveData.value = "${userName.firstName} ${userName.lastName}"
    }
}