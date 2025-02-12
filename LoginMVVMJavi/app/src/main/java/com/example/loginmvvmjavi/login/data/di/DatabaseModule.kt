package com.example.loginmvvmjavi.login.data.di

import android.content.Context
import androidx.room.Room
import com.example.loginmvvmjavi.login.data.LoginDB
import com.example.loginmvvmjavi.login.data.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideLoginDatabase(@ApplicationContext appContext: Context): LoginDB {
        return Room.databaseBuilder(appContext, LoginDB::class.java, "LoginDB").build()
    }
    @Provides
    fun provideUserDao(loginDB:LoginDB): UserDao {
        return loginDB.userDao()
    }
}