package com.example.retrofit_viewmodel

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_viewmodel.network.Repository
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.onSuccess
import kotlinx.coroutines.launch
import org.bumblebeecrew.blossom.app.MySharedPreferencesManager
import org.bumblebeecrew.blossom.network.request.RequestLogin

class MainViewModel(private val repository: Repository) : ViewModel() {

    private var mutableText = MutableLiveData<String>()
    val liveText: LiveData<String>
        get() = mutableText



    fun getPost1() {
        viewModelScope.launch {
            val response = repository.confirm()

            response.onSuccess {
                // handles the success case when the API request gets a successful response.
                Log.e("TAA",this.response.body()?.result.toString())

            }.onError {
                // handles error cases when the API request gets an error response.

            }.onException {
                // handles exceptional cases when the API request gets an exception response.
                this.exception.printStackTrace()
            }
        }
    }

    fun getPost2(requestLogin:RequestLogin) {
        viewModelScope.launch {
            val response = repository.authLogin(requestLogin)

            response.onSuccess {
                // handles the success case when the API request gets a successful response.
                Log.e("onSuccess",this.response.body()?.resultLogin.toString())

            }.onError {
                // handles error cases when the API request gets an error response.
                Log.e("onError",this.errorBody.toString())

            }.onException {
                // handles exceptional cases when the API request gets an exception response.
                Log.e("onException", this.exception.printStackTrace().toString())
            }
        }
    }
}