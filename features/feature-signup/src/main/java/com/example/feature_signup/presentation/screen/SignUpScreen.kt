package com.example.feature_signup.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.feature_signup.presentation.viewmodel.SignUpViewModel
import com.example.ui_components.CustomGradientButton
import com.example.ui_components.InputView
import com.example.ui_components.values.mainTheme

@Composable
fun SignUpScreen(
    navHostController: NavHostController,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .testTag("SignUpScreen")
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(color = mainTheme)
            .padding(40.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "회원가입",
            fontSize = 30.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.testTag("SignUpTextField")
        )

        Spacer(modifier = Modifier.height(40.dp))


        InputView(
            state = viewModel.userId,
            label = "아이디",
            placeholder = "아이디를 입력해 주세요.",
            onValueChange = { viewModel.updateUserId(it) },
            modifier = Modifier.testTag("SignUpIdTextField")
        )

        Spacer(modifier = Modifier.height(15.dp))

        InputView(
            state = viewModel.userPassword,
            label = "비밀번호",
            placeholder = "비밀번호를 입력해 주세요",
            onValueChange = { viewModel.updateUserPassword(it) },
            modifier = Modifier.testTag("SignUpPwTextField")
        )

        Spacer(modifier = Modifier.height(35.dp))

        InputView(
            state = viewModel.userPassword,
            label = "비밀번호 재입력",
            placeholder = "비밀번호를 한번 더 입력해 주세요",
            onValueChange = { viewModel.updateUserCheckPassword(it) },
            modifier = Modifier.testTag("SignUpCheckPwTextField")
        )

        Spacer(modifier = Modifier.height(35.dp))

        CustomGradientButton(
            gradientColors = listOf(Color(0xFFEE6DE7), Color(0xFF857FEB)),
            cornerRadius = 16.dp,
            buttonText = "회원가입",
            roundedCornerShape = RoundedCornerShape(20.dp),
            modifier = Modifier.testTag("SignUpButton")
        ) {
            viewModel.signUp()
        }

    }
}