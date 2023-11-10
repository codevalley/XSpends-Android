package me.nyn.xspends.data.models


data class RefreshTokenResponse(
    val new_token: String,
    val new_refresh_token: String
)
