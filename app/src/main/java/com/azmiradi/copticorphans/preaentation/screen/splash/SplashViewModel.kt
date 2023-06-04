package com.azmiradi.copticorphans.preaentation.screen.splash

import androidx.lifecycle.ViewModel
import com.azmiradi.copticorphans.domain.use_cases.auth.IsLoginUseCase
import com.azmiradi.copticorphans.preaentation.screen.NavigationController
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val isLoginUseCase: IsLoginUseCase
) : ViewModel() {

    fun getAppDestination(): NavigationController.NavigationDestination {
        return if (isLoginUseCase.invoke()) {
            NavigationController.NavigationDestination.GithubRepo
        } else {
            NavigationController.NavigationDestination.Login
        }
    }
}
