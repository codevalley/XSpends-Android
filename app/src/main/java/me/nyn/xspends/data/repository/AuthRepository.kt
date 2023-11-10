package me.nyn.xspends.data.repository
import me.nyn.xspends.data.models.RegisterUserRequest
import me.nyn.xspends.data.models.RegisterUserResponse
import me.nyn.xspends.data.network.ApiService
import retrofit2.Response

class AuthRepository(private val apiService: ApiService) {

    suspend fun registerUser(registerRequest: RegisterUserRequest): RegisterUserResponse {
        val response: Response<RegisterUserResponse> = apiService.registerUser(registerRequest)
        if (response.isSuccessful && response.body() != null) {
            return response.body()!!
        } else {
            // Handle the error according to the error body or the status code
            // For example, throw a custom exception or return a default value
            throw Exception("Registration failed: ${response.errorBody()?.string() ?: "Unknown error"}")
        }
    }

    // ... other repository functions for login, logout, etc. ...
}
