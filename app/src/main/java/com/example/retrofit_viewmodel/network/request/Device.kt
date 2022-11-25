package org.bumblebeecrew.blossom.network.request

import kotlinx.serialization.Serializable

@Serializable

data class Device(
    var id: String?,
    var nickname: String?
)
