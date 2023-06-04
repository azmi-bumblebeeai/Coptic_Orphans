package com.azmiradi.copticorphans.preaentation.ui.component

import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHostState

suspend fun showSnackbar(
    message: String,
    snackbarHostState: SnackbarHostState
) {
    snackbarHostState.showSnackbar(
        message = message,
        duration = SnackbarDuration.Short
    )
}