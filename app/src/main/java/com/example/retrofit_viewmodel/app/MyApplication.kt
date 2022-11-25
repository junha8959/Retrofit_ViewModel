package com.example.retrofit_viewmodel.app

import android.app.Application
import android.content.Context

class MyApplication : Application() {
    init{
        instance = this
    }

    companion object {
        var instance: MyApplication? = null
        var map = HashMap<String, String>()

        fun context() : Context {
            return instance!!.applicationContext
        }

       /* fun pushAuthorization(authorization:String){
            map["Authorization"] = authorization
        }

        fun pushFcmToken(fcmToken:String){
            map["FcmToken"] = fcmToken
        }*/

       /* fun pushMap(_map:HashMap<String, String>){
            map = _map
        }*/

        fun requestHeader(): HashMap<String, String> {
            return map
        }
    }
}