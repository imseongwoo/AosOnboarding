package com.example.feature_login.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.feature_login.presentation.ui_component.IconView
import com.example.feature_login.presentation.ui_component.LoginClickableTextView
import com.example.feature_login.presentation.viewmodel.LoginViewModel
import com.example.ui_components.CustomGradientButton
import com.example.ui_components.InputView
import com.example.ui_components.WhiteButton
import com.example.ui_components.values.mainTheme

val LocalLoginScreenPreviewMode: ProvidableCompositionLocal<Boolean> = compositionLocalOf { false }

@Composable
fun LoginScreen(
    navHostController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel(),
    onNavigateToSignUpScreen: () -> Unit
) {
    if (LocalLoginScreenPreviewMode.current) {
        PreviewLoginScreen()
    } else {
        val scrollState = rememberScrollState()
        val context = LocalContext.current

        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .testTag("LoginScreen")
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .background(color = mainTheme)
                    .padding(40.dp)
            ) {
                IconView()

                Spacer(modifier = Modifier.height(40.dp))

                Text(
                    text = "안녕하세요.\n\n앱이름 입니다.",
                    fontSize = 30.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.testTag("LoginScreenTextField")
                )

                Spacer(modifier = Modifier.height(20.dp))

                InputView(
                    state = viewModel.userId,
                    label = "아이디",
                    placeholder = "아이디를 입력해 주세요.",
                    onValueChange = { viewModel.updateUserId(it) },
                    modifier = Modifier.testTag("LoginScreenIdTextField")
                )

                Spacer(modifier = Modifier.height(15.dp))

                InputView(
                    state = viewModel.userPassword,
                    label = "비밀번호",
                    placeholder = "비밀번호를 입력해 주세요",
                    onValueChange = { viewModel.updateUserPassword(it) },
                    modifier = Modifier.testTag("LoginScreenPwTextField")
                )

                Spacer(modifier = Modifier.height(35.dp))

                CustomGradientButton(
                    gradientColors = listOf(Color(0xFFEE6DE7), Color(0xFF857FEB)),
                    cornerRadius = 16.dp,
                    buttonText = "로그인",
                    roundedCornerShape = RoundedCornerShape(20.dp),
                    modifier = Modifier.testTag("LoginScreenLoginButton")
                ) {
                    viewModel.login()
                }

                Spacer(modifier = Modifier.height(16.dp))

                LoginClickableTextView()

                Spacer(modifier = Modifier.height(10.dp))

                WhiteButton(
                    buttonText = "회원가입",
                    textColor = Color(0xFF857FEB),
                    roundedCornerShape = RoundedCornerShape(20.dp),
                    modifier = Modifier.testTag("LoginScreenSignUpButton")
                ) {
                    onNavigateToSignUpScreen()
                }
            }
        }

    }

}

@Composable
fun PreviewLoginScreen() {
    val scrollState = rememberScrollState()
    val state = remember { mutableStateOf("preview") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(color = Color(0xFF232A39))
            .padding(40.dp)
    ) {
        IconView()

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "안녕하세요.\n\n앱이름 입니다.",
            fontSize = 30.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        InputView(
            state = state,
            label = " 학번",
            placeholder = "학번을 입력해 주세요.",
            onValueChange = { },
            modifier = Modifier
        )

        Spacer(modifier = Modifier.height(15.dp))

        InputView(
            state = state,
            label = "비밀번호",
            placeholder = "비밀번호를 입력해 주세요",
            onValueChange = { },
            modifier = Modifier
        )

        Spacer(modifier = Modifier.height(35.dp))

        CustomGradientButton(
            gradientColors = listOf(Color(0xFFEE6DE7), Color(0xFF857FEB)),
            cornerRadius = 16.dp,
            buttonText = "로그인",
            roundedCornerShape = RoundedCornerShape(20.dp),
            modifier = Modifier
        ) {
        }

        Spacer(modifier = Modifier.height(16.dp))

        LoginClickableTextView()

        Spacer(modifier = Modifier.height(10.dp))

        WhiteButton(
            buttonText = "회원가입",
            textColor = Color(0xFF857FEB),
            roundedCornerShape = RoundedCornerShape(20.dp),
            modifier = Modifier
        ) {

        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    CompositionLocalProvider(LocalLoginScreenPreviewMode provides true) {
        val viewModel: LoginViewModel = hiltViewModel()
        LoginScreen(navHostController = rememberNavController(), viewModel, {})
    }
}
