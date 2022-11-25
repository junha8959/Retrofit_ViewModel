package org.bumblebeecrew.blossom.Model

data class ResponseResult(
    private var result : Result

){
    fun ResponseResult(code: Int, message: String) {
    }
}
