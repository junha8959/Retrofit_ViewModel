package org.bumblebeecrew.blossom.network

import android.content.Context
import android.content.pm.PackageInfo
import android.os.Build
import android.util.Log
import com.example.retrofit_viewmodel.BuildConfig
import com.example.retrofit_viewmodel.app.MyApplication
import com.skydoves.sandwich.adapters.ApiResponseCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.bumblebeecrew.blossom.app.MySharedPreferencesManager
import org.bumblebeecrew.blossom.network.courotine.ResponseAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private val RELEASE_URL = "http://blossom.bumblebeecrew.com/"
    private val DEBUG_URL = "http://test.blossom.bumblebeecrew.com/"
    private val url = "http://192.168.1.2:3000/"

    private lateinit var token: String
    private lateinit var fcmToken: String

    private val okHttpClient =
        OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        })
            .addInterceptor {
                // Request
                val request = it.request()
                    .newBuilder()
                    .addHeader("Authorization", "Bearer $token")
                    .addHeader("OsType", "android")
                    .addHeader("OsVersion", Build.VERSION.RELEASE.toString())
                    .addHeader("AppVersion", versionName().toString())
                    .addHeader("DeviceName", Build.MODEL)
                    .addHeader(
                        "FcmToken",
                        fcmToken
                    )
                    .build()
                // Response
                Log.e("tag","Authorization : Bearer $token \n" +
                        "OsType : android \n"+
                        "OsVersion : ${Build.VERSION.RELEASE.toString()}\n"+
                        "AppVersion : ${versionName().toString()} \n"+
                        "DeviceName : ${Build.MODEL} "
                )
                val response = it.proceed(request)
                response
            }.build()

    private fun getRetrofit(): Retrofit {
        token = MySharedPreferencesManager.getString(MyApplication.context(), "token")
        fcmToken = MySharedPreferencesManager.getString(MyApplication.context(), "fcmToken")
        return Retrofit.Builder()
            .baseUrl(DEBUG_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .build()
    }

    fun getApiService(): RetrofitInterface {
        return getRetrofit().create(RetrofitInterface::class.java)
    }

    fun versionName(): String? {

        val info: PackageInfo = MyApplication.context().packageManager.getPackageInfo(
            MyApplication.context().packageName,
            0
        )
        val appVersionName = info.versionName

        return appVersionName
    }
}