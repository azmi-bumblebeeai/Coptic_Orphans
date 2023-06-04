package com.azmiradi.copticorphans.preaentation.screen.login

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
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

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    onNavigation: (NavigationController.NavigationDestination) -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val snackbarHostState = remember { SnackbarHostState() }

    val accountResult by viewModel.accountResult.collectAsState()
    val loading = remember { mutableStateOf(false) }

    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    ProgressBar(isShow = loading.value)

    when (accountResult) {
        is Result.Initial -> {

        }
        is Result.Loading -> {
            loading.value = true
        }
        is Result.Success -> {
            LaunchedEffect(key1 = Unit){
                loading.value = false
                onNavigation(NavigationController.NavigationDestination.GithubRepo)
            }
        }
        is Result.Error -> {
            loading.value = false
            HandelError(snackbarHostState, accountResult as Result.Error)
        }
    }


    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.login),
                style = MaterialTheme.typography.h4,
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            OutlinedTextField(
                value = emailState.value,
                onValueChange = { emailState.value = it },
                label = { Text(stringResource(id = R.string.email)) },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = passwordState.value,
                onValueChange = { passwordState.value = it },
                label = { Text(stringResource(id = R.string.password)) },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    val email = emailState.value
                    val password = passwordState.value
                    viewModel.login(email, password)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.login))
            }

            Divider(
                modifier = Modifier.padding(10.dp),
                thickness = 1.dp,
                color = Color.Gray
            )

            Button(
                onClick = {
                    val email = emailState.value
                    val password = passwordState.value
                    viewModel.registration(email, password)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.registration))
            }
        }
    }


}


