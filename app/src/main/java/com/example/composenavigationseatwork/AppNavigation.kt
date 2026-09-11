package com.example.composenavigationseatwork

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {
        composable("home") {
            HomeScreen(
                onViewDetailsClick = {
                    navController.navigate("details")
                }
            )
        }

        composable("details") {
            DetailsScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}