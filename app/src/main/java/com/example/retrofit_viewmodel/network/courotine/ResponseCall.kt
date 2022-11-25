package org.bumblebeecrew.blossom.network.courotine

import okhttp3.Request
import okio.Timeout
import org.bumblebeecrew.blossom.Model.CustomResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResponseCall<T> constructor(
    private val callDelegate: Call<T>
) : Call<CustomResult<T>> {

    override fun enqueue(callback: Callback<CustomResult<T>>) = callDelegate.enqueue(object : Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            response.body()?.let {
                when(response.code()) {
                    in 200..299 -> {
                        callback.onResponse(this@ResponseCall, Response.success(CustomResult.Success(it, response.code())))
                    }
                    in 400..409 -> {
                        callback.onResponse(this@ResponseCall, Response.success(CustomResult.ApiError(response.message(), response.code())))
                    }
                }
            }?: callback.onResponse(this@ResponseCall, Response.success(CustomResult.NullResult()))
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            callback.onResponse(this@ResponseCall, Response.success(CustomResult.NetworkError(t)))
            call.cancel()
        }
    })

    override fun clone(): Call<CustomResult<T>> = ResponseCall(callDelegate.clone())

    override fun execute(): Response<CustomResult<T>> = throw UnsupportedOperationException("ResponseCall does not support execute.")

    override fun isExecuted(): Boolean = callDelegate.isExecuted

    override fun cancel() = callDelegate.cancel()

    override fun isCanceled(): Boolean = callDelegate.isCanceled

    override fun request(): Request = callDelegate.request()

    override fun timeout(): Timeout = callDelegate.timeout()
}