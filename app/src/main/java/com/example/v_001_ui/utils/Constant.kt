package com.example.v_001_ui.utils

import com.example.v_001_ui.data.vos.CityVo
import androidx.compose.runtime.mutableStateOf
import com.example.v_001_ui.data.vos.HotelVo

object Constant {

     val mCityList : List<CityVo> = mutableListOf(
         CityVo("All City"),
         CityVo("Yangon"),
         CityVo("Mandalay"),
         CityVo("Pyin Oo Lwin"),
         CityVo("Kalaw"),
         CityVo("Aungban"),
         CityVo("Taunggyi"),
         CityVo("Myit Kyi Na"),
         CityVo("Lashio"),
         CityVo("Bagan"),
         CityVo("Ngwe Saung"),
         CityVo("Chanung Thar"),
     )

    val mHotelList : List<HotelVo> = listOf(
        HotelVo(image = "https://cdn.pixabay.com/photo/2014/07/21/19/20/lobby-398845_1280.jpg", visitedCount = 20, isWishList = mutableStateOf(false),"Hotel Malia","New Work"),
        HotelVo(image = "https://cdn.pixabay.com/photo/2021/12/11/07/59/hotel-6862159_1280.jpg", visitedCount = 223,isWishList = mutableStateOf(false),"Amex Logical","Delhi"),
        HotelVo(image = "https://cdn.pixabay.com/photo/2012/11/21/10/24/building-66789_1280.jpg", visitedCount = 545,isWishList = mutableStateOf(false),"Viter Vix","Chicago"),
        HotelVo(image = "https://cdn.pixabay.com/photo/2014/07/10/17/17/hotel-389256_1280.jpg", visitedCount = 344,isWishList = mutableStateOf(false),"Poiner","Singapore"),
    )
    val mNearByHotelList : List<HotelVo> = listOf(
        HotelVo(image = "https://cdn.pixabay.com/photo/2014/07/21/19/20/lobby-398845_1280.jpg", visitedCount = 20, isWishList = mutableStateOf(false),"Hotel Malia","New Work"),
        HotelVo(image = "https://cdn.pixabay.com/photo/2021/12/11/07/59/hotel-6862159_1280.jpg", visitedCount = 223,isWishList = mutableStateOf(false),"Amex Logical","Delhi"),
        HotelVo(image = "https://cdn.pixabay.com/photo/2012/11/21/10/24/building-66789_1280.jpg", visitedCount = 545,isWishList = mutableStateOf(false),"Viter Vix","Chicago"),
        HotelVo(image = "https://cdn.pixabay.com/photo/2014/07/10/17/17/hotel-389256_1280.jpg", visitedCount = 344,isWishList = mutableStateOf(false),"Poiner","Singapore"),
    )
}