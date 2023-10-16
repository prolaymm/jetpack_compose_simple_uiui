package com.example.v_001_ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun nearMeHotelCard(hotelList : List<HotelVo>, onFavouriteClick : (index : Int) -> Unit) {


   LazyColumn(
  //  userScrollEnabled = false
   ){
       items(hotelList.size) {
           position ->

           Box(
               Modifier
                   .height(120.dp)
                   .fillMaxWidth()){
               Row(

               ){

                   AsyncImage(
                       model = ImageRequest.Builder(LocalContext.current)
                           .data(hotelList[position].image)
                           .crossfade(true)
                           .build(),
                       //placeholder = painterResource(id = R.drawable.loading),
                       error = painterResource(id = R.drawable.error),
                       contentDescription = "Loading",
                       contentScale = ContentScale.Crop,
                       modifier = Modifier
                           .clip(RoundedCornerShape(10.dp))
                           .size(100.dp, 100.dp)) //AsyncImage

                   Spacer(modifier = Modifier.width(8.dp))
                   Column(

                       verticalArrangement = Arrangement.SpaceBetween,
                       modifier = Modifier.fillMaxWidth(0.6f)
                   ) {

                       Text(text = hotelList[position].hotelName, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                       Spacer(modifier = Modifier.height(4.dp))

                       Row {
                           Icon(imageVector = Icons.Outlined.LocationOn,contentDescription = "This", tint = Color.Gray)
                           Text(text ="${ (hotelList[position].distance* (position+1))} km", color = Color.Gray)
                       }//Row
                       Spacer(modifier = Modifier.height(4.dp))
                       Row {
                           Text(text = "${hotelList[position].price}", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                           Text(text ="/Night", color = Color.Gray)
                       }//Row


                   } //column

                   Column(
                       modifier = Modifier.width(300.dp),
                       verticalArrangement = Arrangement.SpaceBetween,
                               horizontalAlignment= Alignment.End,

                   ) {
                      Box(modifier =Modifier.clickable {
                          onFavouriteClick(position)
                      } ){
                        if(hotelList[position].isWishList.value)  Icon(imageVector = Icons.Filled.Favorite,contentDescription = "", tint = Color.Red)
                          else Icon(imageVector = Icons.Outlined.FavoriteBorder,contentDescription = "",tint = Color.Gray)
                      }

                       Spacer(modifier = Modifier.height(28.dp))
                       Box(
                           modifier = Modifier
                               .clip(RoundedCornerShape(8.dp))
                               .background(Color(0xffe6ffe6))
                               .padding(4.dp)

                       ) {
                           Text(text = "${hotelList[position].totalRoom} Room Available", fontSize = 8.sp, color = Color(0xff33ff66))
                       }

                   }

               } //row
           }

       }
   }
}