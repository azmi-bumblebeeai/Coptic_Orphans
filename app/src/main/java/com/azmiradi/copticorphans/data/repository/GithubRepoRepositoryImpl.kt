package com.azmiradi.copticorphans.data.repository

import com.azmiradi.copticorphans.data.network.GitHubService
import com.azmiradi.copticorphans.domain.repository.GithubRepoRepository
import javax.inject.Inject

class GithubRepoRepositoryImpl @Inject constructor(private val gitHubService: GitHubService) :
    GithubRepoRepository {

    override suspend fun getUserRepositories(username: String) =
        gitHubService.getUserRepositories(username)
}