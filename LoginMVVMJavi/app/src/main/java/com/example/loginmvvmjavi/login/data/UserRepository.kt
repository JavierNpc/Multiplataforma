package com.example.loginmvvmjavi.login.data

import com.example.loginmvvmjavi.UI.model.UserFullModel
import com.example.loginmvvmjavi.UI.model.UserModel
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val userDao:UserDao){
    fun getUser(userModel: UserModel) =
        userDao.getUser(userModel.username, userModel.password).map {
            UserModel(it.username, it.password)
        }
    suspend fun addUser(userFullModel: UserFullModel) {
        userDao.addUser(
            UserEntity(
                username = userFullModel.username,
                password = userFullModel.password,
                pile_name = userFullModel.pile_name,
                city = userFullModel.city,
                birthday = userFullModel.birthday
            )
        )
    }
}