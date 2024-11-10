package com.example.feature_signup

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.compose.rememberNavController
import com.example.feature_signup.presentation.screen.SignUpScreen
import com.example.feature_signup.presentation.viewmodel.SignUpViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SignUpScreenTest {

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
        val viewModel = SignUpViewModel()
        SignUpScreen(navHostController = navController, viewModel = viewModel)
    }

    @Test
    fun signup_screen_should_show() {
        composeTestRule.onNodeWithTag("SignUpScreen").assertIsDisplayed()
    }

    @Test
    fun signup_text_should_show() {
        composeTestRule.onNodeWithTag("SignUpTextField").assertIsDisplayed()
    }

    @Test
    fun signup_id_text_should_show() {
        composeTestRule.onNodeWithTag("SignUpIdTextField").assertIsDisplayed()
    }

    @Test
    fun signup_pw_text_should_show() {
        composeTestRule.onNodeWithTag("SignUpPwTextField").assertIsDisplayed()
    }

    @Test
    fun signup_check_pw_text_should_show() {
        composeTestRule.onNodeWithTag("SignUpCheckPwTextField").assertIsDisplayed()
    }

    @Test
    fun signup_button_should_show() {
        composeTestRule.onNodeWithTag("SignUpButton").assertIsDisplayed()
    }

    @Test
    fun signup_screen_inputFields_and_button_work_correctly() {
        composeTestRule.onNodeWithTag("SignUpIdTextField")
            .performTextInput("testUser")
        composeTestRule.onNodeWithTag("SignUpPwTextField")
            .performTextInput("password123")
        composeTestRule.onNodeWithTag("SignUpCheckPwTextField")
            .performTextInput("password123")

        composeTestRule.onNodeWithTag("SignUpIdTextField")
            .assertTextContains("testUser")
        composeTestRule.onNodeWithTag("SignUpPwTextField")
            .assertTextContains("password123")
        composeTestRule.onNodeWithTag("SignUpCheckPwTextField")
            .assertTextContains("password123")

        composeTestRule.onNodeWithTag("SignUpButton").performClick()

    }
}
