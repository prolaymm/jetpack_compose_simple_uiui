package com.example.v_001_ui.composable

import android.graphics.Color
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun searchField( value : String, hint: String = "Search here" ,onValueChange  : (it : String)-> Unit) {


    TextField(value =value ,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(color = androidx.compose.ui.graphics.Color.Gray),
        leadingIcon = {
          Icon(imageVector = Icons.Outlined.Search, contentDescription = "Search")
        },

        colors = TextFieldDefaults.textFieldColors(
            disabledTextColor =  androidx.compose.ui.graphics.Color.Transparent,
            focusedIndicatorColor =  androidx.compose.ui.graphics.Color.Transparent,
            unfocusedIndicatorColor =  androidx.compose.ui.graphics.Color.Transparent,
            disabledIndicatorColor =  androidx.compose.ui.graphics.Color.Transparent,
        ) ,
        placeholder = { Text(hint)},
        onValueChange = onValueChange)
}