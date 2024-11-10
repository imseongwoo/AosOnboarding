package com.example.feature_login

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.compose.rememberNavController
import com.example.feature_login.presentation.screen.LoginScreen
import com.example.feature_login.presentation.viewmodel.LoginViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoginScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            TestScreen()
        }
    }

    @Composable
    private fun TestScreen() {
        val navController = rememberNavController()
        val viewModel = LoginViewModel()
        LoginScreen(
            navHostController = navController,
            viewModel = viewModel,
            onNavigateToSignUpScreen = {})
    }

    @Test
    fun login_screen_should_show() {
        composeTestRule.onNodeWithTag("LoginScreen").assertIsDisplayed()
    }

    @Test
    fun login_screen_id_text_field_should_show() {
        composeTestRule.onNodeWithTag("LoginScreenIdTextField").assertIsDisplayed()
    }

    @Test
    fun login_screen_pw_text_field_should_show() {
        composeTestRule.onNodeWithTag("LoginScreenPwTextField").assertIsDisplayed()
    }

    @Test
    fun login_screen_login_button_should_show() {
        composeTestRule.onNodeWithTag("LoginScreenLoginButton").assertIsDisplayed()
    }

    @Test
    fun login_screen_sign_up_button_should_show() {
        composeTestRule.onNodeWithTag("LoginScreenSignUpButton").assertIsDisplayed()
    }

    @Test
    fun login_screen_input_fields_and_button_work_correctly() {
        composeTestRule.onNodeWithTag("LoginScreenIdTextField")
            .performTextInput("testUser")
        composeTestRule.onNodeWithTag("LoginScreenPwTextField")
            .performTextInput("password123")

        composeTestRule.onNodeWithTag("LoginScreenIdTextField")
            .assertTextContains("testUser")
        composeTestRule.onNodeWithTag("LoginScreenPwTextField")
            .assertTextContains("password123")

        composeTestRule.onNodeWithTag("LoginScreenSignUpButton").performClick()
    }
}