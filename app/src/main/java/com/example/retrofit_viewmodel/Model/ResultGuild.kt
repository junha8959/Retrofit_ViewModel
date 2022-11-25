package org.bumblebeecrew.blossom.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class ResultGuild(
    @SerializedName("code") @Expose  var code: String,
    @SerializedName("id") @Expose  var id: String,
    @SerializedName("name") @Expose  var name: String,
    @SerializedName("iconUrl") @Expose  var iconUrl: String,
    @SerializedName("volume") @Expose  var volume: String,
    @SerializedName("playType") @Expose  var playType: String,
    @SerializedName("isAutoSaveVolume") @Expose  var isAutoSaveVolume: String,
    @SerializedName("insertDate") @Expose  var insertDate: String
)