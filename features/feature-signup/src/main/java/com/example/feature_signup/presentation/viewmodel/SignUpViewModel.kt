package com.example.feature_signup.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
) : ViewModel() {
    private val _userId = mutableStateOf("")
    val userId: State<String> = _userId

    private val _userPassword = mutableStateOf("")
    val userPassword: State<String> = _userPassword

    private val _userCheckPassword = mutableStateOf("")
    val userCheckPassword: State<String> = _userCheckPassword

    fun signUp() {
    }
    fun updateUserId(userId: String) {
        _userId.value = userId
    }

    fun updateUserPassword(userPassword: String) {
        _userPassword.value = userPassword
    }

    fun updateUserCheckPassword(userCheckPassword: String) {
        _userCheckPassword.value = userCheckPassword
    }

}