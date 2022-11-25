package org.bumblebeecrew.blossom.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class ResultDevices(
    @SerializedName("code") @Expose  var code: String,
    @SerializedName("id") @Expose  var id: String,
    @SerializedName("name") @Expose  var name: String,
    @SerializedName("nickname") @Expose  var nickname: String,
    @SerializedName("fcmToken") @Expose  var fcmToken: String,
    @SerializedName("insertDate") @Expose  var insertDate: String

//    @SerializedName("guilds") @Expose  var guilds: String
)