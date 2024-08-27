package com.idat.apppt73013468.home.domain

import com.idat.apppt73013468.home.data.network.response.PhotosResponse
import com.idat.apppt73013468.home.data.repository.PacienteRepository
import javax.inject.Inject

class ListarPhotosUseCase @Inject constructor(
    private val repository: PacienteRepository
){

    suspend operator fun invoke(): PhotosResponse {
        return repository.listarPhotos()
    }
}