package org.bumblebeecrew.blossom.network

import android.content.Context
import android.content.pm.PackageInfo
import android.os.Build
import com.example.retrofit_viewmodel.BuildConfig
import com.example.retrofit_viewmodel.app.MyApplication
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.bumblebeecrew.blossom.app.MySharedPreferencesManager
import org.bumblebeecrew.blossom.network.courotine.ResponseAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClient {
    private val RELEASE_URL = "http://blossom.bumblebeecrew.com/"
    private val DEBUG_URL = "http://test.blossom.bumblebeecrew.com/"
    private val url = "http://192.168.1.2:3000/"

    private lateinit var token: String
    private lateinit var fcmToken : String

    private val okHttpClient = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }).addInterceptor {
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
        val response = it.proceed(request)
        response
    }.build()

    /*private val json = Json {
        isLenient = true // Json 큰따옴표 느슨하게 체크.
        ignoreUnknownKeys = true // Field 값이 없는 경우 무시
        coerceInputValues = true // "null" 이 들어간경우 default Argument 값으로 대체


        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
    }*/

    private fun getRetrofit(context: Context): Retrofit {
        token = MySharedPreferencesManager.getString(context, "token")
        fcmToken = MySharedPreferencesManager.getString(context, "fcmToken")
        return Retrofit.Builder()
            .baseUrl(DEBUG_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getApiService(context: Context): RetrofitInterface {
        return getRetrofit(context).create(RetrofitInterface::class.java)
    }

    fun versionName(): String? {

        val info: PackageInfo = MyApplication.context().packageManager.getPackageInfo(MyApplication.context().packageName, 0)
        val appVersionName = info.versionName

        return appVersionName
    }
}