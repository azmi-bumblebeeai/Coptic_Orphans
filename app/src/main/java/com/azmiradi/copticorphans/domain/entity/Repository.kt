package com.azmiradi.copticorphans.domain.entity

data class Repository(
    val id: Int,
    val name: String,
    val description: String?,
    val language: String?,
    val stargazersCount: Int,
)
