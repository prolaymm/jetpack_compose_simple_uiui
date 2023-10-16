package com.example.v_001_ui.data.repo.impl

import com.example.v_001_ui.data.repo.PostRepo
import com.example.v_001_ui.data.vos.PostVo
import com.example.v_001_ui.service.ApiEndpoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostRepoImpl @Inject constructor(private val endPoint : ApiEndpoint) : PostRepo {
    override suspend fun getAllPost(): Flow<List<PostVo>> = flow {

        emit(endPoint.getPost())
    }.flowOn(Dispatchers.IO)


}