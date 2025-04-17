package com.example.todolist.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todolist.ui.feature.AddEditScreen
import com.example.todolist.ui.feature.ListScreen
import kotlinx.serialization.Serializable
import androidx.navigation.toRoute


@Serializable
object ListRoute

@Serializable
data class AddEditRoute (val id: Long? = null)

@Composable
fun  TodoNavHost(){
    val navController = rememberNavController()
    NavHost(navController =  navController, startDestination = ListRoute) {
        composable<ListRoute> {
            ListScreen(
                navigateToAddEditScreen = {id ->
                    navController.navigate(AddEditRoute(id = id))
                }
            )
        }
        composable<AddEditRoute> { backStackEntry ->
            val addEditRoute = backStackEntry.toRoute<AddEditRoute>()
            AddEditScreen()
        }
    }
}