package com.example.loginmvvmjavi.login.domain

import com.example.loginmvvmjavi.UI.model.UserModel
import com.example.loginmvvmjavi.login.data.UserRepository
import kotlinx.coroutines.flow.count
import javax.inject.Inject

class CheckUserUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke(userModel: UserModel):Boolean =
        userRepository.getUser(userModel).count() > 0
}