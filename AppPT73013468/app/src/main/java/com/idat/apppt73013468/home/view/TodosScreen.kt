package com.idat.apppt73013468.home.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.idat.apppt73013468.home.viewmodel.PacienteViewModel
import com.idat.apppt73013468.home.data.network.response.TodosResponseItem

@Composable
fun TodosScreen(
    modifier: Modifier = Modifier,
    pacienteViewModel: PacienteViewModel,
    onBackToHome: () -> Unit = {}
) {
    val todosResponse = pacienteViewModel.todosResponse.value
    Column(modifier = modifier
        .fillMaxSize()
        .padding(top = 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier.fillMaxWidth()) {
            FloatingActionButton(
                onClick = { onBackToHome() },
                shape = CircleShape,
                modifier = Modifier
                    //.align(Alignment.End)
                    .padding(start = 24.dp)
            ) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
            }

            Text(
                modifier = Modifier.padding(start = 24.dp, top = 12.dp),
                text = "TodosScreen",
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Italic,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }



        todosResponse?.let { todos ->
            LazyColumn(
                modifier = modifier
                    //.fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(todos) { todo ->
                    TodoCard(todo)
                }
            }
        } ?: run {
            // Mostrar un texto mientras se cargan los datos o en caso de error
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Cargando datos...")
            }
        }


//        Box(modifier = Modifier.fillMaxSize()) {
            // Contenido de la pantalla


//        }


    }
}

@Composable
fun TodoCard(todo: TodosResponseItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "User ID: ${todo.userId}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "ID: ${todo.id}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Title: ${todo.title}", style = MaterialTheme.typography.bodyMedium)
            Text(
                text = "Completed: ${if (todo.completed) "Yes" else "No"}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
