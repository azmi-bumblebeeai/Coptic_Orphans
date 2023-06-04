package com.azmiradi.copticorphans.preaentation.ui.component

import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.azmiradi.copticorphans.domain.Result

@Composable
fun HandelError(snackbarHostState: SnackbarHostState, accountResult: Result.Error) {
    val exception = accountResult.exception
    LaunchedEffect(exception) {
        showSnackbar(
            exception.message ?: "",
            snackbarHostState
        )
    }
}
