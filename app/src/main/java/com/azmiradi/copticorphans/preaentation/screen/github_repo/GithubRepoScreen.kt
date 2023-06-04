package com.azmiradi.copticorphans.preaentation.screen.github_repo

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.azmiradi.copticorphans.domain.Result
import com.azmiradi.copticorphans.domain.entity.Repository
import com.azmiradi.copticorphans.preaentation.ui.component.HandelError
import com.azmiradi.copticorphans.preaentation.ui.component.ProgressBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun GithubRepoScreen(
    viewModel: GithubRepoViewModel = hiltViewModel()
) {
    val snackbarHostState = remember { SnackbarHostState() }

    val accountResult by viewModel.githubRepoResult.collectAsState()
    val loading = remember { mutableStateOf(false) }
    val githubRepositories = remember { mutableStateListOf<Repository>() }



    when (accountResult) {
        is Result.Initial -> {

        }
        is Result.Loading -> {
            loading.value = true
        }
        is Result.Success -> {
            val repositories = (accountResult as Result.Success).data
            LaunchedEffect(key1 = repositories) {
                githubRepositories.clear()
                githubRepositories.addAll(repositories)
                loading.value = false
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
        ProgressBar(isShow = loading.value)
        LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp),
            content = {
                items(githubRepositories) {
                    RepositoryItem(it)
                }
            })
    }


}

@Composable
fun RepositoryItem(repository: Repository) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = repository.name,
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = repository.description ?: "",
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Star Icon",
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = repository.stargazersCount.toString(),
                    style = TextStyle(fontSize = 14.sp),
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = repository.language ?: "",
                    style = TextStyle(fontSize = 14.sp),
                    color = Color.Gray
                )
            }
        }
    }
}


