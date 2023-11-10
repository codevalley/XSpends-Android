package me.nyn.xspends.data.network

import me.nyn.xspends.data.models.*
import retrofit2.http.POST
import retrofit2.http.Body

import retrofit2.Response

interface ApiService {
    @POST("/auth/register")
    suspend fun registerUser(@Body registerUserRequest: RegisterUserRequest): Response<RegisterUserResponse>

    @POST("/auth/login")
    suspend fun loginUser(@Body loginUserRequest: LoginUserRequest): Response<LoginUserResponse>

    @POST("/auth/refresh")
    suspend fun refreshToken(@Body refreshTokenRequest: RefreshTokenRequest): Response<RefreshTokenResponse>

    @POST("/auth/logout")
    suspend fun logoutUser(): LogoutResponse // Assuming SimpleResponse is a class with just a message field
}