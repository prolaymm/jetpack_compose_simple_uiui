package com.example.v_001_ui.service

import com.example.v_001_ui.utils.ApiConstant
import com.example.v_001_ui.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiService {


    @Provides
    @Singleton
    fun provideBaseUrl() : String = ApiConstant.BASE_URL


    @Provides
    @Singleton
    fun provideRetrofit(url : String) : Retrofit{

        return  Retrofit
            .Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
     fun provideApiEndPoint(retrofit: Retrofit) : ApiEndpoint = retrofit.create(ApiEndpoint::class.java)



}