package com.azmiradi.copticorphans.domain.use_cases.github_rebo

import com.azmiradi.copticorphans.domain.Result
import com.azmiradi.copticorphans.domain.entity.Repository
import com.azmiradi.copticorphans.domain.repository.GithubRepoRepository
import javax.inject.Inject

class GetGithubRepoForUserUseCase @Inject constructor(private val githubRepoRepository: GithubRepoRepository) {
    suspend operator fun invoke(username: String): Result<List<Repository>> {
        return try {
            Result.Loading
            val repoRepository = githubRepoRepository.getUserRepositories(username)
            Result.Success(repoRepository)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}