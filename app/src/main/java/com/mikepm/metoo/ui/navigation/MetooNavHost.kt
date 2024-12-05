package com.mikepm.metoo.ui.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mikepm.metoo.ui.screens.AccountScreen
import com.mikepm.metoo.ui.screens.EventsScreen
import com.mikepm.metoo.ui.screens.MainScreen
import com.mikepm.metoo.ui.screens.MapScreen
import com.mikepm.metoo.ui.screens.RatingScreen
import com.mikepm.metoo.ui.screens.auth.AuthScreen
import com.mikepm.metoo.ui.screens.auth.SignInScreen
import com.mikepm.metoo.ui.screens.auth.SignUpScreen

@Composable
fun MetooNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.AuthScreen.route,
        modifier = modifier,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        composable(Screen.AccountScreen.route) {
            AccountScreen()
        }

        composable(Screen.EventsScreen.route) {
            EventsScreen()
        }

        composable(Screen.MapScreen.route) {
            MapScreen()
        }

        composable(Screen.RatingScreen.route) {
            RatingScreen()
        }

        composable(Screen.MainScreen.route) {
            MainScreen()
        }

        composable(Screen.SignUpScreen.route) {
            SignUpScreen(navController)
        }

        composable(Screen.AuthScreen.route) {
            AuthScreen(navController)
        }
    }
}