package com.idat.apppt73013468.home.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.idat.apppt73013468.home.data.network.response.PhotosResponseItem
import com.idat.apppt73013468.home.viewmodel.PacienteViewModel

@Composable
fun PhotosScreen(
    modifier: Modifier = Modifier,
    pacienteViewModel: PacienteViewModel,
    onBackToHome: () -> Unit = {}
) {
    val photosResponse = pacienteViewModel.photosResponse.value
    Column(modifier = modifier.fillMaxSize().padding(top = 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "PhotosScreen",
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        photosResponse?.let { photos ->
            val filteredPhotos = photos.filter { it.albumId % 2 == 0 }
            LazyRow(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(filteredPhotos) { photo ->
                    PhotoCard(photo)
                }
            }
        } ?: run {
            // Mostrar un texto mientras se cargan los datos o en caso de error
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Cargando datos...")
            }
        }

        Box(modifier = Modifier.fillMaxSize()) {
            // Contenido de la pantalla

            FloatingActionButton(
                onClick = { onBackToHome() },
                shape = CircleShape,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
            }
        }


    }

}


@Composable
fun PhotoCard(photo: PhotosResponseItem) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = photo.thumbnailUrl,
                contentDescription = "Thumbnail Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = photo.title, style = MaterialTheme.typography.bodyMedium, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "ID: ${photo.id}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "ALBUM-ID: ${photo.albumId}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
