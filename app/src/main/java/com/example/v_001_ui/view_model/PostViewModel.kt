package com.example.v_001_ui.view_model

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.v_001_ui.data.repo.PostRepo
import com.example.v_001_ui.data.repo.impl.PostRepoImpl
import com.example.v_001_ui.data.vos.PostVo
import com.example.v_001_ui.service.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private  val postRepo: PostRepoImpl) : ViewModel() {


     val postResult : MutableStateFlow<ApiState<List<PostVo>>> = MutableStateFlow(ApiState.Loading())

    val composeState : StateFlow<ApiState<List<PostVo>>> = postResult

    val list = mutableListOf<PostVo>()
    init {
        Log.d("Arjun", "init sta")
        getPost()
    }

    fun getPost() {

        GlobalScope.launch {
            postResult.value = ApiState.Loading()
            postRepo.getAllPost().catch {
               Log.d("Arjun", "error ${it.message}")
                postResult.value = ApiState.Failure(it.message?:"Something gone wrong")
            }.collect{
                postResult.value = ApiState.Success(it)
            }
        }
    }


}