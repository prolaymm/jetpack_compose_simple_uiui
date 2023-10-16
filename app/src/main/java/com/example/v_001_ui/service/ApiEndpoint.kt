package com.example.v_001_ui.service

import com.example.v_001_ui.data.vos.PostVo
import retrofit2.http.GET

interface ApiEndpoint {
    @GET("posts")
   suspend fun getPost() :  List<PostVo>



}