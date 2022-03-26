package com.example.domain.usecase

import com.example.domain.models.UserName
import com.example.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return UserName(
            firstName = userRepository.getName().firstName,
            lastName = userRepository.getName().lastName
        )
    }
}