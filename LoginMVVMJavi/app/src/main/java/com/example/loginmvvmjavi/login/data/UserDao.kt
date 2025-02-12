package com.example.loginmvvmjavi.login.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM UserEntity")
    fun getAllUsers(): Flow<List<UserEntity>>

    @Insert
    suspend fun addUser(item: UserEntity)

    @Delete
    suspend fun delUser(id:Int)

    @Query("SELECT * FROM UserEntity " +
            "WHERE username = :name " +
            "AND password = :pass")
    fun getUser(name:String, pass:String): Flow<UserEntity>
}