package me.nyn.xspends.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import me.nyn.xspends.data.models.RegisterUserRequest
import me.nyn.xspends.data.models.RegisterUserResponse
import me.nyn.xspends.data.repository.AuthRepository
import javax.inject.Inject

// ... other imports ...

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<RegisterUiState>(RegisterUiState.Empty)
    val uiState: StateFlow<RegisterUiState> = _uiState.asStateFlow()

    // ... existing code ...

    // Example of setting UI state
    fun register(username: String, password: String, email: String) {
        viewModelScope.launch {
            _uiState.value = RegisterUiState.Loading
            try {
                val response = authRepository.registerUser(RegisterUserRequest(username, password, email))
                _uiState.value = RegisterUiState.Success(response)
            } catch (e: Exception) {
                _uiState.value = RegisterUiState.Error(e.localizedMessage ?: "An unexpected error occurred")
            }
        }
    }
}

sealed class RegisterUiState {
    object Empty : RegisterUiState()
    object Loading : RegisterUiState()
    data class Success(val user: RegisterUserResponse) : RegisterUiState()
    data class Error(val message: String) : RegisterUiState()
}
