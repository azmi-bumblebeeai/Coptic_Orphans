package com.azmiradi.copticorphans.domain.repository

import com.azmiradi.copticorphans.domain.entity.Repository

interface GithubRepoRepository {
    suspend fun getUserRepositories(username: String): List<Repository>
}