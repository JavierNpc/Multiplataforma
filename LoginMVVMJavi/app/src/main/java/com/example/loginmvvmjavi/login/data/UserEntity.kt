package com.example.loginmvvmjavi.login.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    var username:String,
    var password:String,
    var pile_name:String,
    var city:String,
    var birthday: String
)

// Para usar DATE hay que usar datawraps