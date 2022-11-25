package org.bumblebeecrew.blossom.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class ResultConfirm(
/*
    val iosMinVersion: String,
    val iosCurrentVersion: String,
    val androidMinVersion: String,
    val androidCurrentVersion:String,
    val isAccessible: String,
    val noticeTitle: String,
    val noticeContent: String,
    val noticeUrl:String
*/
    @SerializedName("iosMinVersion") @Expose var iosMinVersion: String,
    @SerializedName("iosCurrentVersion") @Expose var iosCurrentVersion: String,
    @SerializedName("androidMinVersion") @Expose var androidMinVersion: String,
    @SerializedName("androidCurrentVersion") @Expose var androidCurrentVersion: String,
    @SerializedName("isAccessible") @Expose var isAccessible: String,
    @SerializedName("noticeTitle") @Expose var noticeTitle: String,
    @SerializedName("noticeContent") @Expose var noticeContent: String,
    @SerializedName("noticeUrl") @Expose var noticeUrl: String
)