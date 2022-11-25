package org.bumblebeecrew.blossom.app

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferencesManager private constructor(){
    companion object {
        private var sPref: SharedPreferences? = null
        private var editor: SharedPreferences.Editor? = null

        private fun getInstance(context: Context): SharedPreferences {
            synchronized(this) {
                sPref = context.getSharedPreferences("Blossom", Context.MODE_PRIVATE)
                return sPref!!
            }
        }

        fun putLong(context: Context, key: String, value: Long) {
            editor = getInstance(context).edit()
            editor!!.putLong(key, value)
            editor!!.apply()
        }

        fun getLong(context: Context, key: String,): Long {
            return getInstance(context).getLong(key, 0)
        }

        fun putString(context: Context, key: String, value: String) {
            editor = getInstance(context).edit()
            editor!!.putString(key, value)
            editor!!.apply()
        }

        fun getString(context: Context, key: String): String {
            return getInstance(context).getString(key, "")!!
        }

        fun putInt(context: Context, key: String, value: Int) {
            editor = getInstance(context).edit()
            editor!!.putInt(key, value)
            editor!!.apply()
        }

        fun getInt(context: Context, key: String): Int {
            return getInstance(context).getInt(key, 0)
        }


       /* fun versionName(): String? {
            val info: PackageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
            val appVersionName = info.versionName

            return appVersionName
        }

        fun requestHeader(): HashMap<String, String> {

            map["auth"] = ""
            map["OsType"] = "android"
            map["OsVersion"] = Build.VERSION.RELEASE.toString()
            map["AppVersion"] =versionName().toString()
            map["DeviceName"] = Build.MODEL
            map["FcmToken"] = "fkMUktPbVkIkhPVcD18J19:APA91bGcaROgzkz8I8EJbG7DbiK6j-zjm-wYqxDjYgbpdtae-vf3xXYAcAwsQf25ZfNlf1LFGRgLYrvnnsVV3Buc3xjITs0hv2TCq2w-Y1nN4eGcrYArpkcIECBrlSArVKiNOh8gJ2F-"
            map["Authorization"] = ""
            return map
        }*/
    }
}