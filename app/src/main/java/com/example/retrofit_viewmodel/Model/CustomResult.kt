package org.bumblebeecrew.blossom.Model

sealed class CustomResult<T> {

    class Success<T>(val data: T, val code: Int) : CustomResult<T>()

    class Loading<T> : CustomResult<T>()

    class ApiError<T>(val message: String, val code: Int) : CustomResult<T>()

    class NetworkError<T>(val throwable: Throwable) : CustomResult<T>()

    class NullResult<T> : CustomResult<T>()
}