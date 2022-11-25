package org.bumblebeecrew.blossom.network.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable

data class RequestAccount(
    @SerializedName("id") @Expose var id: String?,
    @SerializedName("password") @Expose var password: String?,
    @SerializedName("type") @Expose var type: String?,
    @SerializedName("nickname") @Expose var nickname: String?,
    @SerializedName("email") @Expose var email: String?,
    @SerializedName("deviceId") @Expose var deviceId: String?,
    @SerializedName("deviceNickname") @Expose var deviceNickname: String?
)