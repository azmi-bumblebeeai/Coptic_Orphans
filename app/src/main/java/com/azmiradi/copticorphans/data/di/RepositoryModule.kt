package com.azmiradi.copticorphans.data.di

import com.azmiradi.copticorphans.data.network.GitHubService
import com.azmiradi.copticorphans.data.repository.AuthRepositoryImpl
import com.azmiradi.copticorphans.data.repository.GithubRepoRepositoryImpl
import com.azmiradi.copticorphans.domain.repository.AuthRepository
import com.azmiradi.copticorphans.domain.repository.GithubRepoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideUserRepository(): AuthRepository {
        return AuthRepositoryImpl()
    }

    @Provides
    fun provideGithubRepoRepository(gitHubService: GitHubService): GithubRepoRepository {
        return GithubRepoRepositoryImpl(gitHubService)
    }
}