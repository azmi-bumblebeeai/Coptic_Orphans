package com.azmiradi.copticorphans.preaentation.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.azmiradi.copticorphans.preaentation.screen.github_repo.GithubRepoScreen
import com.azmiradi.copticorphans.preaentation.screen.login.LoginScreen
import com.azmiradi.copticorphans.preaentation.screen.splash.SplashScreen

class NavigationController {

    @Composable
    fun NavigationComponent() {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = NavigationDestination.Login.root
        ) {
            composable(NavigationDestination.Splash.root) {
                SplashScreen(onNavigation = { navDestination ->
                    navController.navigate(navDestination.root) {
                        popUpTo(navDestination.root) {
                            inclusive = true
                        }
                    }
                })
            }

            composable(NavigationDestination.Login.root) {
                LoginScreen(onNavigation = {
                    navController.navigate(it.root) {
                        popUpTo(it.root) {
                            inclusive = true
                        }
                    }
                })
            }

            composable(NavigationDestination.GithubRepo.root) {
                GithubRepoScreen()
            }
        }
    }

    enum class NavigationDestination(val root: String) {
        Splash("splash"),
        Login("login"),
        GithubRepo("github_repo")
    }
}