package com.example.retrofit_viewmodel.network

import com.example.retrofit_viewmodel.app.MyApplication
import org.bumblebeecrew.blossom.network.RetrofitClient
import org.bumblebeecrew.blossom.network.RetrofitInterface
import org.bumblebeecrew.blossom.network.request.RequestLogin

class Repository {
    private val retrofitInterface : RetrofitInterface = RetrofitClient.getApiService()

    suspend fun confirm() = retrofitInterface.confirm()

    suspend fun authLogin(requestLogin:RequestLogin) = retrofitInterface.authLogin(requestLogin)
}