package com.example.v_001_ui.composable

import CityVo
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable

 fun allCity(cityList : List<CityVo> = mutableListOf(),onClick: ( id: Int) -> Unit, selectedIndex : Int =0 ){

     LazyRow{
         items(cityList.size){position ->
            OutlinedButton(
                modifier = Modifier.padding(end = 8.dp),
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = if(selectedIndex == position)MaterialTheme.colorScheme.primaryContainer  else Color.White
                ),
                onClick = {
                onClick(position)
            }) {
                if(position== selectedIndex){
                    Icon( imageVector = Icons.Outlined.LocationOn,contentDescription = "")
                }
                Text(text = cityList[position].name)

            }
         }
     }

 }