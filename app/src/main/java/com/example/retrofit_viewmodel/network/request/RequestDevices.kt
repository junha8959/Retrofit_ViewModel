package org.bumblebeecrew.blossom.network.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable

data class RequestDevices(
    @SerializedName("id") @Expose var id: String?,
    @SerializedName("type") @Expose var type: String?
)
