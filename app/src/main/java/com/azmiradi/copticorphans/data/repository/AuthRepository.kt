package com.azmiradi.copticorphans.data.repository

import com.azmiradi.copticorphans.domain.entity.User
import com.azmiradi.copticorphans.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class AuthRepositoryImpl : AuthRepository {
    private val auth = FirebaseAuth.getInstance()

    override suspend fun registration(email: String, password: String): User {
        return suspendCoroutine { continuation ->
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user = task.result?.user
                        if (user != null) {
                            continuation.resume(User(user.uid, user.email ?: ""))
                        } else {
                            continuation.resumeWithException(Exception("User creation failed"))
                        }
                    } else {
                        continuation.resumeWithException(
                            task.exception ?: Exception("User creation failed")
                        )
                    }
                }
        }
    }

    override suspend fun login(email: String, password: String): User {
        return suspendCoroutine { continuation ->
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user = task.result?.user
                        if (user != null) {
                            continuation.resume(User(user.uid, user.email ?: ""))
                        } else {
                            continuation.resumeWithException(Exception("User login failed"))
                        }
                    } else {
                        continuation.resumeWithException(
                            task.exception ?: Exception("User login failed")
                        )
                    }
                }
        }
    }

    override fun isLogin() = auth.currentUser != null
}