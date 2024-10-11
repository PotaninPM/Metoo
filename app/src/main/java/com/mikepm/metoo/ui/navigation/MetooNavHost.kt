package com.mikepm.metoo.ui.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentComposer
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mikepm.metoo.ui.screens.AccountScreen
import com.mikepm.metoo.ui.screens.RatingScreen
import java.lang.reflect.Modifier

@Composable
fun MetooNavHost(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        composable(Screen.AccountScreen.route) {
            AccountScreen()
        }

        composable(Screen.RatingScreen.route) {
            RatingScreen()
        }
    }
}