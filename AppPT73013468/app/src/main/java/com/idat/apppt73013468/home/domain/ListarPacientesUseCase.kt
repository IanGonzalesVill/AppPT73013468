//package com.idat.apppt73013468.home.domain
//
//import com.idat.apppt73013468.core.bd.PacienteEntity
//import com.idat.apppt73013468.home.data.network.response.TodosResponse
//import com.idat.apppt73013468.home.data.repository.PacienteRepository
//import javax.inject.Inject
//
//class ListarPacientesUseCase @Inject constructor(
//    private val repository: PacienteRepository
//){
//
//    suspend operator fun invoke(): List<PacienteEntity> {
//        return repository.listarPacientes()
//    }
//}