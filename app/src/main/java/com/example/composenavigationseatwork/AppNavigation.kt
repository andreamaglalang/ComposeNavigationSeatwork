package com.example.composenavigationseatwork

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation(modifier: Modifier){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = Modifier
    ){
        composable("home"){
            HomeScreen(
                onNavigate = { studentId, studentName, course ->
                    navController.navigate("details/$studentId/$studentName/$course")
                }
            )
        }
        composable(
            route = "details/{studentId}/{studentName}/{course}",
            arguments = listOf(
                navArgument(name = "studentId"){
                    type = NavType.StringType
                },
                navArgument(name = "studentName"){
                    type = NavType.StringType
                },
                navArgument(name = "course"){
                    type = NavType.StringType
                }
            )) { backStackEntry ->
            val studentId = backStackEntry.arguments?.getString("studentId")
            val studentName = backStackEntry.arguments?.getString("studentName")
            val course = backStackEntry.arguments?.getString("course")
            DetailsScreen(
                studentId = studentId,
                studentName = studentName,
                course = course,
                onBack = {
                    navController.popBackStack()
                },
                onEdit = {
                    navController.popBackStack()
                }
            )
        }
    }
}