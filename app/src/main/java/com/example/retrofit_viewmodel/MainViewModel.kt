package com.example.retrofit_viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofit_viewmodel.app.MyApplication
import org.bumblebeecrew.blossom.Model.DataClassConfirm
import org.bumblebeecrew.blossom.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private var mutableText = MutableLiveData<String>()
    val liveText: LiveData<String>
        get() = mutableText

    fun getPost1() {

        val api = RetrofitClient.getApiService(MyApplication.context()).confirm()
        api.enqueue(object : Callback<DataClassConfirm> {
            override fun onResponse(
                call: Call<DataClassConfirm>,
                response: Response<DataClassConfirm>
            ) {
                mutableText.value = response.toString()
                Log.e("getPost1", "getPost1")
            }

            override fun onFailure(call: Call<DataClassConfirm>, t: Throwable) {
                Log.d("FAIL", "FAIL")
            }

        })

    }


    fun getPost2(num: Int) {

        val api = RetrofitClient.getApiService(MyApplication.context()).confirm()
        api.enqueue(object : Callback<DataClassConfirm> {
            override fun onResponse(
                call: Call<DataClassConfirm>,
                response: Response<DataClassConfirm>
            ) {
                mutableText.value = response.toString()
                Log.e("getPost2", "getPost2")
            }

            override fun onFailure(call: Call<DataClassConfirm>, t: Throwable) {
                Log.d("FAIL", "FAIL")
            }

        })
    }

}