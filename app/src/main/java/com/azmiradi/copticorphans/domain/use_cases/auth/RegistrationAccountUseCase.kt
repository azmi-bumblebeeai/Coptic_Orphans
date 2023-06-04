package com.azmiradi.copticorphans.domain.use_cases.auth

import com.azmiradi.copticorphans.domain.entity.User
import com.azmiradi.copticorphans.domain.repository.AuthRepository
import javax.inject.Inject
import com.azmiradi.copticorphans.domain.Result

class RegistrationAccountUseCase @Inject constructor(private val userRepository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): Result<User> {
        return try {
            Result.Loading
            val user = userRepository.registration(email, password)
            Result.Success(user)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}