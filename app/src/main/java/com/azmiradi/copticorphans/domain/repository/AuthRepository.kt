package com.azmiradi.copticorphans.domain.repository

import com.azmiradi.copticorphans.domain.entity.User


interface AuthRepository {
    suspend fun registration(email: String, password: String): User
    suspend fun login(email: String, password: String): User
    fun isLogin():Boolean
}