package com.example.feature_navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun CustomBottomNavigation(
    modifier: Modifier = Modifier,
    items: List<BottomNavItem>,
    navHostController: NavHostController,
    onNavigate: (BottomNavItem) -> Unit
) {
    val backStackEntry = navHostController.currentBackStackEntryAsState()
    Row(
        modifier
            .fillMaxWidth()
            .background(Color(0xFF141414)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        items.forEach { navItem ->
            key(navItem.route) {
                val isSelected = navItem.route == backStackEntry.value?.destination?.route
                NavItem(item = navItem, selected = isSelected) { destination ->
                    onNavigate(destination)
                }
            }
        }
    }
}

@Composable
private fun NavItem(item: BottomNavItem, selected: Boolean, onItemClick: (BottomNavItem) -> Unit) {
    Column(
        Modifier
            .clickable {
                onItemClick(item)
            }
            .padding(10.dp)) {
        if (selected) {
            Icon(
                imageVector = item.icon,
                contentDescription = item.configuration,
                tint = Color(0xFFFFC107)
            )
        } else {
            Icon(
                imageVector = item.icon,
                contentDescription = item.configuration,
                tint = Color.White
            )
        }
    }
}

@Composable
@Preview
fun CustomBottomNavigationPreview() {
    CustomBottomNavigation(
        items = listOf(
            BottomNavItem(
                icon = Icons.Default.Person,
                route = Route.LOGIN,
                configuration = Route.LOGIN
            ),
            BottomNavItem(
                icon = Icons.Default.Info,
                route = Route.SIGNUP,
                configuration = Route.SIGNUP
            )
        ), navHostController = rememberNavController()
    ) {

    }
}

@Composable
@Preview
fun NavItemPreview() {
    NavItem(
        item = BottomNavItem(
            icon = Icons.Default.Home,
            route = "홈",
            configuration = "홈"
        ),
        selected = true
    ) {

    }
}