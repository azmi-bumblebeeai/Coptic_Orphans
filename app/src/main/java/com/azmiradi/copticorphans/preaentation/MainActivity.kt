package com.azmiradi.copticorphans.preaentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.azmiradi.copticorphans.preaentation.screen.NavigationController
import com.azmiradi.copticorphans.preaentation.screen.login.LoginScreen
import com.azmiradi.copticorphans.preaentation.ui.theme.CopticOrphansTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navigationDestination = NavigationController()
        setContent {
            CopticOrphansTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    navigationDestination.NavigationComponent()
                }
            }
        }
    }
}

