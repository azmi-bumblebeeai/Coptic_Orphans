package com.azmiradi.copticorphans.domain.use_cases.auth

import com.azmiradi.copticorphans.domain.repository.AuthRepository
import javax.inject.Inject

class IsLoginUseCase @Inject constructor(private val userRepository: AuthRepository) {
    operator fun invoke() = userRepository.isLogin()
}