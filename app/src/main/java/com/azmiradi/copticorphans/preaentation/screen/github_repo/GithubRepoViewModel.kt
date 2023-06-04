package com.azmiradi.copticorphans.preaentation.screen.github_repo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.azmiradi.copticorphans.domain.Result
import com.azmiradi.copticorphans.domain.entity.Repository
import com.azmiradi.copticorphans.domain.entity.User
import com.azmiradi.copticorphans.domain.use_cases.auth.LoginAccountUseCase
import com.azmiradi.copticorphans.domain.use_cases.auth.RegistrationAccountUseCase
import com.azmiradi.copticorphans.domain.use_cases.github_rebo.GetGithubRepoForUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GithubRepoViewModel @Inject constructor(
    private val getGithubRepoForUserUseCase: GetGithubRepoForUserUseCase,
) : ViewModel() {
    private val _githubRepoResult = MutableStateFlow<Result<List<Repository>>>(Result.Initial)
    val githubRepoResult: StateFlow<Result<List<Repository>>> = _githubRepoResult.asStateFlow()

    private fun getGithubRepo(username: String) {
        _githubRepoResult.value = Result.Loading

        viewModelScope.launch {
             val result = getGithubRepoForUserUseCase(username)
            _githubRepoResult.value = result
        }
    }

    init {
        getGithubRepo("azmiradi")
    }

}
