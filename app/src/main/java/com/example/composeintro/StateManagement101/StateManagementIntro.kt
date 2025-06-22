package com.example.composeintro.StateManagement101

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StateManagementIntro(){
    var userName = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }
    Column (modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustText("Merhaba Android")
        Spacer(modifier = Modifier.padding(10.dp))
        CustText("MErhanba Bilal")
        Spacer(modifier  = Modifier.padding(10.dp))
        CustText("Merhaba ÇAvuş")
        Spacer(modifier = Modifier.padding(10.dp))
        CustomTextField(userName.value, "user name", onValueChangeFunction = {
            userName.value = it
        })
        Spacer(modifier = Modifier.padding(10.dp))
        CustomTextField(password.value, "password" ,onValueChangeFunction = {
            password.value = it
        })
        Button(onClick = {

        }) {
            Text(text = "Click Me")
        }
    }
}