package com.example.v_001_ui.data.vos

import com.google.gson.annotations.SerializedName

data class PostVo (
     @SerializedName("id")
    val userid: Long,
     @SerializedName("user_id")
    val id: Long,
     @SerializedName("title")
    val title: String,
     @SerializedName("body")
    val body: String
)

