package org.bumblebeecrew.blossom.network.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RequestGuild(
    @SerializedName("status") @Expose var status: String?,
    @SerializedName("syncCode") @Expose var syncCode: String?
)