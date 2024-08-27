package com.idat.apppt73013468.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.idat.apppt73013468.auth.view.LoginScreen
import com.idat.apppt73013468.auth.viewmodel.LoginViewModel
import com.idat.apppt73013468.home.view.HomeScreen
import com.idat.apppt73013468.home.view.PhotosScreen
import com.idat.apppt73013468.home.view.TodosScreen
import com.idat.apppt73013468.home.viewmodel.PacienteViewModel


@Composable
fun NavigationWrapper(
    modifier: Modifier,
    navHostController: NavHostController,
    loginViewModel: LoginViewModel,
    pacienteViewModel: PacienteViewModel,

    ) {

    NavHost(navController = navHostController, startDestination = "login") {
        composable("login") {
            //modifier = modifier
            LoginScreen(
                modifier = modifier,
                navigateToHome = { navHostController.navigate(route = "home") },
                loginViewModel = loginViewModel
            )
        }
        composable("home") {
            HomeScreen(
                modifier = modifier,
                navigateToTodos = { navHostController.navigate(route = "todos") },
                navigateToPhotos = { navHostController.navigate(route = "photos") }
            )
        }
        composable("todos") {
            TodosScreen(
                modifier = modifier,
                pacienteViewModel = pacienteViewModel,
                onBackToHome = { navHostController.navigate(route = "home") }
            )
        }
        composable("photos"){
            PhotosScreen(
                modifier = modifier,
                pacienteViewModel = pacienteViewModel,
                onBackToHome = { navHostController.navigate(route = "home") }
            )
        }
    }

}
