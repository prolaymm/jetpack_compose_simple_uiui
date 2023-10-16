package com.example.v_001_ui.data.vos

import androidx.compose.runtime.MutableState
import java.util.Random

data class HotelVo(var image : String,var visitedCount : Int, var isWishList : MutableState<Boolean>,var hotelName : String,var city : String,var rating : Double = 5.0,val distance : Int =  Random().nextInt(6),val price : Int = Random().nextInt(200),val totalRoom : Int = Random().nextInt(13) )
