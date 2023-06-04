package com.azmiradi.copticorphans.data.network

import com.azmiradi.copticorphans.domain.entity.Repository
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("users/{username}/repos")
    suspend fun getUserRepositories(@Path("username") username: String): List<Repository>
}