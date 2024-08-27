package com.idat.apppt73013468.home.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessibilityNew
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToTodos: () -> Unit = {},
    navigateToPhotos: () -> Unit = {}
) {
    // Estado del ModalDrawer y del ítem seleccionado
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedItem by remember { mutableStateOf("None") }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.fillMaxHeight().padding(16.dp)
            ) {
                Text(
                    text = "Menu",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(16.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                NavigationDrawerItem(
                    icon = { Icon(imageVector = Icons.Filled.AccessibilityNew, contentDescription = "Todos") },
                    label = { Text("Todos") },
                    selected = selectedItem == "Todos",
                    onClick = {
                        selectedItem = "Todos"
                        scope.launch { drawerState.close() }
                        navigateToTodos()
                    }
                )
                NavigationDrawerItem(
                    icon = { Icon(imageVector = Icons.Filled.PhotoLibrary, contentDescription = "Photos") },
                    label = { Text("Photos") },
                    selected = selectedItem == "Photos",
                    onClick = {
                        selectedItem = "Photos"
                        scope.launch { drawerState.close() }
                        navigateToPhotos()
                    }
                )
            }
        }
    ) { // Esto es el contenido principal de la pantalla
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text(text = "HomeScreen") },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(imageVector = Icons.Filled.List, contentDescription = "Menu")
                        }
                    }
                )
            },
            content = { paddingValues ->
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(paddingValues) // Usa paddingValues aquí
                        .padding(16.dp)
                ) {
                    Text(text = "Bienvenido a la HomeScreen")
                    // Puedes agregar más contenido aquí che
                }
            }
        )
    }
}

