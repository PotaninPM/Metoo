package com.mikepm.metoo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mikepm.metoo.R
import com.mikepm.metoo.ui.navigation.BottomNavItem
import com.mikepm.metoo.ui.navigation.MetooNavBar
import com.mikepm.metoo.ui.navigation.MetooNavHost
import com.mikepm.metoo.ui.navigation.Screen

@Composable
fun MainScreen() {
    val topLevelDestinations = listOf(
        BottomNavItem(
            route = Screen.EventsScreen.route,
            labelRes = R.string.events_bottom,
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home
        ),
        BottomNavItem(
            route = Screen.MapScreen.route,
            labelRes = R.string.map_bottom,
            selectedIcon = Icons.Filled.Place,
            unselectedIcon = Icons.Outlined.Place
        ),
        BottomNavItem(
            route = Screen.RatingScreen.route,
            labelRes = R.string.rating_bottom,
            selectedIcon = ImageVector.vectorResource(id = R.drawable.trophy_filled),
            unselectedIcon = ImageVector.vectorResource(id = R.drawable.trophy_outlined)
        ),
        BottomNavItem(
            route = Screen.AccountScreen.route,
            labelRes = R.string.profile,
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home
        )
    )
    val localNavController = rememberNavController()
    val currentRoute = localNavController.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute in topLevelDestinations.map { it.route }) {
                MetooNavBar(
                    navController = localNavController,
                    destinations = topLevelDestinations
                )
            }
        },
        contentWindowInsets = WindowInsets(top = 0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            MetooNavHost(
                navController = localNavController,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            )
        }
    }

}
