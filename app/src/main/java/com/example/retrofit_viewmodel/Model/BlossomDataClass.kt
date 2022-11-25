package org.bumblebeecrew.blossom.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*       "result": [
        {
        "id": "952059589900263445",
        "name": "Crew Only",
        "type": "category",
        "parentId": null
        }
     ]*/
// DTO 모델 - PostResult Class 선언

data class BlossomDataClass(
    @SerializedName("code") @Expose var code: String,
    @SerializedName("message") @Expose var message: String,
    @SerializedName("result") @Expose var result: List<Result>
){
    override fun toString(): String { // toString()을 Override 해주지 않으면 객체 주소값을 출력함
        return "ClassPojo[" +
                "code=" + code +
                ", message=" + message +
                ", blossomData='" + result + '\'' +
                ']'
    }
}


