package com.idat.apppt73013468

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.idat.apppt73013468.auth.viewmodel.LoginViewModel
import com.idat.apppt73013468.core.bd.PacienteDatabase
import com.idat.apppt73013468.home.viewmodel.PacienteViewModel
import com.idat.apppt73013468.navigation.NavigationWrapper
import com.idat.apppt73013468.ui.theme.AppPT73013468Theme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

//    @Inject
//    lateinit var pacienteDatabase: PacienteDatabase

    private lateinit var navHostController: NavHostController
    private val loginViewModel: LoginViewModel by viewModels()
    private val pacienteViewModel: PacienteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            navHostController = rememberNavController()
            AppPT73013468Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //pacienteDatabase.pacienteDao()
                    NavigationWrapper(
                        modifier = Modifier.padding(innerPadding),
                        navHostController = navHostController,
                        loginViewModel = loginViewModel,
                        pacienteViewModel = pacienteViewModel
                    )
                }
            }
        }
    }
}
