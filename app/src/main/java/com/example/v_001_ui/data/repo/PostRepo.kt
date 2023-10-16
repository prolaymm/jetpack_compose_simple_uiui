package com.example.v_001_ui.data.repo

import com.example.v_001_ui.data.vos.PostVo
import kotlinx.coroutines.flow.Flow

interface  PostRepo {

    suspend fun  getAllPost() : Flow<List<PostVo>>
}