package com.example.v_001_ui.service

sealed  class ApiState<T>(val data: T? = null,val message: String? = "") {

    class  Loading<T> : ApiState<T>()
    class Success<T>(data : T? = null) : ApiState<T>(data = data)

    class Failure<T> (message :  String) : ApiState<T>(message=message)
}