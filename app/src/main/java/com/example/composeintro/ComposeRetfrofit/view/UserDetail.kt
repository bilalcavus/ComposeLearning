package com.example.composeintro.ComposeRetfrofit.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.composeintro.ComposeRetfrofit.model.User

@Composable
fun UserDetail(user: User){
    Text(user.name)
}