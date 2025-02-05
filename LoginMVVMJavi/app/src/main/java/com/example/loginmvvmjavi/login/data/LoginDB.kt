package com.example.loginmvvmjavi.login.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class]  , version = 1)
abstract class LoginDB: RoomDatabase(){
    abstract fun userDao(): UserDao

}