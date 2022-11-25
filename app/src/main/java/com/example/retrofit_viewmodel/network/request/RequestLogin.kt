package org.bumblebeecrew.blossom.network.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RequestLogin(
    @SerializedName("id") @Expose var id: String?,
    @SerializedName("password") @Expose var password: String?,
    @SerializedName("type") @Expose var type: String?,
    @SerializedName("deviceId") @Expose var deviceId: String?
)