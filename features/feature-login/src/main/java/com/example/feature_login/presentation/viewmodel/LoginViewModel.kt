package com.example.feature_login.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
) : ViewModel() {
    private val _userId = mutableStateOf("")
    val userId: State<String> = _userId

    private val _userPassword = mutableStateOf("")
    val userPassword: State<String> = _userPassword

    fun login() {
    }
    fun updateUserId(userId: String) {
        _userId.value = userId
    }

    fun updateUserPassword(userPassword: String) {
        _userPassword.value = userPassword
    }

}