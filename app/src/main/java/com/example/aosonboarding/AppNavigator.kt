package com.example.aosonboarding

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.feature_login.presentation.screen.LoginScreen
import com.example.feature_login.presentation.viewmodel.LoginViewModel
import com.example.feature_navigation.Route

@Composable
fun AppNavigator(
    navHostController: NavHostController,
    uiRoute: State<String>,
    onNavigate: (String) -> Unit
) {
    val loginViewModel: LoginViewModel = hiltViewModel()

    NavHost(
        navController = navHostController,
        startDestination = Route.LOGIN
    ) {
        composable(Route.LOGIN) {
            onNavigate(Route.LOGIN)
            LoginScreen(navHostController, loginViewModel, onNavigateToSignUpScreen = {})
        }

        composable(Route.SIGNUP) {
            onNavigate(Route.SIGNUP)
        }
    }
}