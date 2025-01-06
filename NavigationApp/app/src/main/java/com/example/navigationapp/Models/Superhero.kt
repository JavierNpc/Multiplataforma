package com.example.navigationapp.Models

import androidx.annotation.DrawableRes
import java.util.concurrent.Flow.Publisher

data class Superhero(
    var superHeroName: String,
    var realName : String,
    var publisher: String,
    @DrawableRes var picture: Int
){


}
