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
import com.example.feature_signup.presentation.screen.SignUpScreen
import com.example.feature_signup.presentation.viewmodel.SignUpViewModel

@Composable
fun AppNavigator(
    navHostController: NavHostController,
    uiRoute: State<String>,
    onNavigate: (String) -> Unit
) {
    val loginViewModel: LoginViewModel = hiltViewModel()
    val signUpViewModel: SignUpViewModel = hiltViewModel()

    NavHost(
        navController = navHostController,
        startDestination = Route.LOGIN
    ) {
        composable(Route.LOGIN) {
            onNavigate(Route.LOGIN)
            LoginScreen(navHostController, loginViewModel, onNavigateToSignUpScreen = {
                navHostController.navigate("SIGNUP")
            })
        }

        composable(Route.SIGNUP) {
            onNavigate(Route.SIGNUP)
            SignUpScreen(navHostController, signUpViewModel)
        }
    }
}