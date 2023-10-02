package com.example.v_001_ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
fun nearYouText(location : String) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = "Near You", fontSize = 24.sp, fontWeight = FontWeight.Bold)

            Row{
                Text(text = location,)
                Icon(imageVector = Icons.Outlined.KeyboardArrowDown,contentDescription = "", tint = Color.Gray)
            }
        }
        Text(text = "See More", fontSize = 20.sp, fontWeight = FontWeight.Bold,color=Color.Red)
    }
}