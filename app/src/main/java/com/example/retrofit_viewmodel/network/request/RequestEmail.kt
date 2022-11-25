package org.bumblebeecrew.blossom.network.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable

data class RequestEmail(
    @SerializedName("email") @Expose var email: String?,
    @SerializedName("deviceId") @Expose var deviceId: String?
)