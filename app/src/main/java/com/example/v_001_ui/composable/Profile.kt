package com.example.v_001_ui.composable

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.v_001_ui.R

@Preview
@Composable

 fun makeProfile( title : String ="Find Your Hotel",subtitle: String = "Hi, Arjun",image : Int = R.drawable.profile ){

  return  Box(modifier = Modifier.background(Color.White)){
      Row(
          horizontalArrangement = Arrangement.SpaceBetween
      ) {
       Box(modifier = Modifier.fillMaxWidth(0.8f)){
           Column {
               Text(subtitle, color = Color.Gray, fontSize = 16.sp)
               Text(title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
           }
       }
          Image(painter = painterResource(id = image), contentDescription = "Profile",
              modifier = Modifier.clip(RoundedCornerShape(8.dp))
                  .width(60.dp)
                  .height(60.dp)
          )
      }
  }
 }