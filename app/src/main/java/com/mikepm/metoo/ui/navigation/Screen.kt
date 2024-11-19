package com.mikepm.metoo.ui.navigation

sealed class Screen(val route: String) {
    data object MainScreen : Screen("main_screen")

    data object EventsScreen : Screen("events_screen")
    data object MapScreen : Screen("map_screen")
    data object RatingScreen : Screen("rating_screen")
    data object SignUpScreen : Screen("sign_up_screen")
    data object SignInScreen : Screen("sign_in_screen")
    data object AccountScreen : Screen("account_screen")
}