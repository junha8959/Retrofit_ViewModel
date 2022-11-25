package org.bumblebeecrew.blossom.network.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable

data class RequestDevice(
    @SerializedName("email") @Expose var email: String?,
    @SerializedName("device") @Expose var device: Device?
)
