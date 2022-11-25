package org.bumblebeecrew.blossom.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class ResultLogin(
    @SerializedName("token") @Expose  var token: String,
    @SerializedName("code") @Expose  var code: String,
    @SerializedName("id") @Expose  var id: String,
    @SerializedName("type") @Expose  var type: String,
    @SerializedName("nickname") @Expose  var nickname: String,
    @SerializedName("email") @Expose  var email: String,
    @SerializedName("guilds") @Expose  var guilds: List<ResultGuild>
)