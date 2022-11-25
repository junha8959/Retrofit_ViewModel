package org.bumblebeecrew.blossom.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class Result(
    @SerializedName("id") @Expose var id: String,
    @SerializedName("name") @Expose var name: String,
    @SerializedName("type") @Expose var type: String,
    @SerializedName("parentId") @Expose var parentId: String
)