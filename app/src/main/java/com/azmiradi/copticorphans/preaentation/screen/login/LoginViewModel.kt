package com.azmiradi.copticorphans.preaentation.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.azmiradi.copticorphans.domain.Result
import com.azmiradi.copticorphans.domain.entity.User
import com.azmiradi.copticorphans.domain.use_cases.auth.LoginAccountUseCase
import com.azmiradi.copticorphans.domain.use_cases.auth.RegistrationAccountUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val registrationAccountUseCase: RegistrationAccountUseCase,
    private val loginAccountUseCase: LoginAccountUseCase
) : ViewModel() {
    private val _accountResult = MutableStateFlow<Result<User>>(Result.Initial)
    val  accountResult: StateFlow<Result<User>> = _accountResult.asStateFlow()

    fun registration(email: String, password: String) {
        viewModelScope.launch {
            _accountResult.value = Result.Loading
            val result = registrationAccountUseCase(email, password)
            _accountResult.value = result
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _accountResult.value = Result.Loading
            val result = loginAccountUseCase(email, password)
            _accountResult.value = result
        }
    }
}
