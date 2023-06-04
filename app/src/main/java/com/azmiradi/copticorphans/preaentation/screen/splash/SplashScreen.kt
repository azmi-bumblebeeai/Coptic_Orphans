package com.azmiradi.copticorphans.preaentation.screen.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.azmiradi.copticorphans.R
import com.azmiradi.copticorphans.domain.Result
import com.azmiradi.copticorphans.preaentation.screen.NavigationController
import com.azmiradi.copticorphans.preaentation.ui.component.HandelError
import com.azmiradi.copticorphans.preaentation.ui.component.ProgressBar
import com.azmiradi.copticorphans.preaentation.ui.component.showSnackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SplashScreen(
    onNavigation: (NavigationController.NavigationDestination) -> Unit,
    viewModel: SplashViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = Unit) {
        delay(2000)
        onNavigation(viewModel.getAppDestination())
    }

    Box(Modifier.fillMaxSize()) {
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "",
            modifier = Modifier.size(100.dp),
            tint = Color.Black
        )
    }
}
