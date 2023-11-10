package me.nyn.xspends.data.models

data class RegisterUserRequest(
    val username: String,
    val password: String,
    val email: String
)
