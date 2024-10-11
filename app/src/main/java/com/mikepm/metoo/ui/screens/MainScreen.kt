package com.mikepm.metoo.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.mikepm.metoo.R
import com.mikepm.metoo.ui.navigation.BottomNavItem
import com.mikepm.metoo.ui.navigation.Screen

@Composable
fun MainScreen() {
    val topLevelDestinations = listOf {
        BottomNavItem(
            route = Screen.HomeScreen.route,
            labelRes = R.string.main,
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home
        )
    }
}
