package org.bumblebeecrew.blossom.network.courotine

import org.bumblebeecrew.blossom.Model.CustomResult
import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

class ResponseAdapter<T>(
    private val successType : Type
) : CallAdapter<T, Call<CustomResult<T>>> {
    override fun responseType(): Type = successType

    override fun adapt(call: Call<T>): Call<CustomResult<T>> = ResponseCall(call)
}

