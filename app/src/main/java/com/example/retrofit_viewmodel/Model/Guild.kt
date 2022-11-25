package org.bumblebeecrew.blossom.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class Guild(
    @SerializedName("code") @Expose var code: String,
    @SerializedName("message") @Expose var message: String
) {
    override fun toString(): String { // toString()을 Override 해주지 않으면 객체 주소값을 출력함
        return "ClassPojo[" +
                "code=" + code +
                ", message=" + message +
                ']'
    }
}