package com.example.aosonboarding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.aosonboarding.ui.theme.AosOnboardingTheme
import com.example.feature_navigation.BottomNavItem
import com.example.feature_navigation.Route
import com.example.feature_navigation.CustomBottomNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AosOnboardingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navHostController = rememberNavController()
                    val uiRoute = remember { mutableStateOf(Route.LOGIN) }
                    Scaffold(
                        topBar = {},
                        bottomBar = {
                            if (uiRoute.value == "HOME" || uiRoute.value == "GRAPH" || uiRoute.value == "SETTINGS") {
                                CustomBottomNavigation(
                                    modifier = Modifier.height(60.dp),
                                    items = listOf(
                                        BottomNavItem(
                                            icon = Icons.Default.Home,
                                            route = Route.LOGIN,
                                            configuration = Route.LOGIN
                                        ),
                                        BottomNavItem(
                                            icon = Icons.Default.Person,
                                            route = Route.SIGNUP,
                                            configuration = Route.SIGNUP
                                        )
                                    ), navHostController = navHostController
                                ) {
                                    navHostController.navigate(it.route) {
                                        navHostController.popBackStack()
                                    }
                                }
                            }
                        },

                        ) {
                        Column(modifier = Modifier.padding(it)) {
                            AppNavigator(
                                navHostController = navHostController,
                                uiRoute = uiRoute
                            ) { uiRoute.value = it }
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AosOnboardingTheme {
        Greeting("Android")
    }
}