package com.azmiradi.copticorphans.domain

sealed class Result<out T> {
    object Initial : Result<Nothing>()
    object Loading : Result<Nothing>()
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}