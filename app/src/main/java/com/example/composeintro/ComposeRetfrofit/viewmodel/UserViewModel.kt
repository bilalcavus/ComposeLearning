package com.example.composeintro.ComposeRetfrofit.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeintro.ComposeRetfrofit.service.RetrofitClient
import com.example.composeintro.ComposeRetfrofit.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    val users =  mutableStateOf<List<User>>(listOf())

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error



    fun fetchUsers(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
               users.value = RetrofitClient.apiService.getUsers()
            }
            catch( e: Exception) {
                _error.value = e.message ?: "An error occurred"

            }
        }
    }
}