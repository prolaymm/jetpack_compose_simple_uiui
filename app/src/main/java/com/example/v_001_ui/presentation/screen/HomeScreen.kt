package com.example.v_001_ui.presentation.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.v_001_ui.composable.allCity
import com.example.v_001_ui.composable.hotelCard
import com.example.v_001_ui.composable.makeProfile
import com.example.v_001_ui.composable.nearMeHotelCard
import com.example.v_001_ui.composable.nearYouText
import com.example.v_001_ui.composable.searchField
import com.example.v_001_ui.data.HotelVo
import com.example.v_001_ui.utils.Constant

@Preview
@Composable
fun HomeScreen() {

    val mHotelList : SnapshotStateList<HotelVo>   = remember { Constant.mHotelList.toMutableStateList() }
    val nearHotelList : SnapshotStateList<HotelVo>   = remember { Constant.mNearByHotelList.toMutableStateList() }


    val inputState  = remember { mutableStateOf("")}
    val selectedLocationIndex  = remember { mutableStateOf(0)}
    fun onFavouriteHotel(index : Int) {
        mHotelList[index].isWishList.value =   !mHotelList[index].isWishList.value
        Log.d("Arjun","${mHotelList[index].isWishList}")
    }
    fun onFavouriteNearHotel(index : Int) {
        nearHotelList[index].isWishList.value =   !nearHotelList[index].isWishList.value
        Log.d("Arjun","${mHotelList[index].isWishList}")
    }

    Column(modifier = Modifier.padding(horizontal = 12.dp)) {
        Spacer(modifier = Modifier.height(14.dp))
        makeProfile()
        Spacer(modifier = Modifier.height(14.dp))
        searchField(inputState.value, onValueChange = {inputValue ->
            inputState.value = inputValue

            Log.d("Arjun","E${inputState.value}")
        })
        Spacer(modifier = Modifier.height(14.dp))
        allCity(cityList =Constant.mCityList,
            onClick = {position->
            selectedLocationIndex.value = position
        },selectedLocationIndex.value )
        Spacer(modifier = Modifier.height(14.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Most Visited", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Icon(imageVector = Icons.Outlined.KeyboardArrowRight,
                contentDescription = "Icon", tint = MaterialTheme.colorScheme.primary, modifier = Modifier
                    .width(40.dp)
                    .height(40.dp))
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .verticalScroll(rememberScrollState())

        ) {

            Spacer(modifier = Modifier.height(14.dp))


            if(selectedLocationIndex.value ==0) {
                hotelCard(mHotelList = mHotelList, onFavouriteClick = {
                        index ->
                    onFavouriteHotel(index)
                    //  mHotelList.value[index].isWishList =   !mHotelList.value[index].isWishList
                })
            }else {
                Text(text = "Coming Soon", textAlign = TextAlign.Center)
            }
            Spacer(modifier = Modifier.height(14.dp))
            nearYouText("In your  Area ${Constant.mCityList[selectedLocationIndex.value].name}")
            Spacer(modifier = Modifier.height(14.dp))
          if(selectedLocationIndex.value ==0)  Box(modifier = Modifier.height(400.dp)) {
                nearMeHotelCard(nearHotelList) { index ->
                    onFavouriteNearHotel(index)
                }
            }// Box
            else {
                Text("Coming Soon")
          }
        }

    }

}