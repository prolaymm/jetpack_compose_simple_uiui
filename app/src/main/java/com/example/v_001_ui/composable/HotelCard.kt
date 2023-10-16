package com.example.v_001_ui.composable

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.v_001_ui.R
import com.example.v_001_ui.data.vos.HotelVo


@SuppressLint("ResourceType")
@Composable
fun hotelCard(mHotelList: SnapshotStateList<HotelVo>, onFavouriteClick : (index : Int) -> Unit){

    LazyRow{
     items(mHotelList.size) {
         position ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(240.dp, 280.dp)
                .padding(end = 16.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(mHotelList[position].image)
                    .crossfade(true)
                    .build(),
                //placeholder = painterResource(id = R.drawable.loading),
                error = painterResource(id = R.drawable.error),
                contentDescription = "Loading",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .size(240.dp, 280.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.TopCenter)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                ) {

                Box(modifier = Modifier
                    .clip(RoundedCornerShape(50.dp))
                    .background(color = Color.White)
                    .padding(4.dp)
                ){

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(imageVector = Icons.Outlined.Info, contentDescription = "", tint = Color.Green, modifier = Modifier.size(16.dp,16.dp))
                        Text(text = "${mHotelList[position].visitedCount}}Visited",  fontSize = 10.sp, fontWeight = FontWeight.Bold)
                    }
                }
                Box(modifier = Modifier.clickable {
                  //  !mHotelList[position].isWishList
                    onFavouriteClick(position)
                }){
                    Icon(imageVector = if(mHotelList[position].isWishList.value) Icons.Outlined.Favorite else Icons.Outlined.FavoriteBorder,contentDescription = "", tint =  Color.White)

                }
              }


           Row (
               modifier = Modifier
                   .align(Alignment.BottomStart)
                   .padding(
                       12.dp
                   )
                   .fillMaxWidth(),
               verticalAlignment =Alignment.Bottom,
               horizontalArrangement = Arrangement.SpaceBetween
           ){

               Column(
                   horizontalAlignment = Alignment.Start,

               ) {
                   Row(
                       horizontalArrangement = Arrangement.Center,
                       verticalAlignment = Alignment.CenterVertically
                   ) {
                       Icon(imageVector = Icons.Outlined.LocationOn, contentDescription = "", tint = Color.White, modifier = Modifier.size(12.dp))
                       Text(text = "${mHotelList[position].city}",  fontSize = 14.sp, fontWeight = FontWeight.Normal, color = Color.White)
                   }

                   Text(text = "${mHotelList[position].hotelName}",  fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)

               }

               Row {
                   Icon(imageVector = Icons.Outlined.Star,contentDescription = "", tint = Color.Yellow)
                   Text(text = "${mHotelList[position].rating}",  fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Yellow)
               }

           }
        }

     }
    }
}