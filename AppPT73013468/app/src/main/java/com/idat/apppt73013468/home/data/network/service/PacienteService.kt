package com.idat.apppt73013468.home.data.network.service

import com.idat.apppt73013468.core.bd.PacienteDao
import com.idat.apppt73013468.core.bd.PacienteEntity
import com.idat.apppt73013468.core.retrofit.PacienteClient
import com.idat.apppt73013468.home.data.network.response.PhotosResponse
import com.idat.apppt73013468.home.data.network.response.TodosResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class PacienteService @Inject constructor(
    private val pacienteClient: PacienteClient,
//    private val pacienteDao: PacienteDao
) {

    suspend fun listarTodos(): TodosResponse {
        return withContext(Dispatchers.IO){
            val response = pacienteClient.listarTodos()
            response.body()!!
        }
    }

    suspend fun listarPhotos(): PhotosResponse {
        return withContext(Dispatchers.IO){
            val response = pacienteClient.listarPhotos()
            response.body()!!
        }
    }

//    suspend fun listarPacientes(): List<PacienteEntity> {
//        return withContext(Dispatchers.IO){
//            val response = pacienteDao.listarPacientes()
//            response.getValue()!!
//        }
//    }


//    suspend fun registrarVoluntario(
//        voluntarioRequest: VoluntarioRequest
//    ): VoluntarioResponse{
//        return withContext(Dispatchers.IO){
//            val response = pacienteClient.registrarVoluntario(voluntarioRequest)
//            response.body()!!
//        }
//    }

}