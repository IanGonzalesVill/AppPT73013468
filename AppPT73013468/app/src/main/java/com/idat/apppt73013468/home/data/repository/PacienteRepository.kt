package com.idat.apppt73013468.home.data.repository

import com.idat.apppt73013468.core.bd.PacienteEntity
import com.idat.apppt73013468.core.model.PacienteModel
import com.idat.apppt73013468.home.data.network.response.PhotosResponse
import com.idat.apppt73013468.home.data.network.response.TodosResponse
import com.idat.apppt73013468.home.data.network.service.PacienteService
import javax.inject.Inject

class PacienteRepository @Inject constructor(
    private  val pacienteService: PacienteService
) {

    suspend fun listarTodos(): TodosResponse{
        return pacienteService.listarTodos()
    }

    suspend fun listarPhotos(): PhotosResponse{
        return pacienteService.listarPhotos()
    }

//    suspend fun listarPacientes(): List<PacienteEntity>{
//        return pacienteService.listarPacientes()
//    }

//    suspend fun registrarVoluntario(voluntarioRequest: VoluntarioRequest):
//            VoluntarioResponse{
//        return mascotaService.registrarVoluntario(voluntarioRequest)
//    }
}