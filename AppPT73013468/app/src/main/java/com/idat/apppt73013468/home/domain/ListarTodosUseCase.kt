package com.idat.apppt73013468.home.domain

import com.idat.apppt73013468.home.data.network.response.TodosResponse
import com.idat.apppt73013468.home.data.repository.PacienteRepository
import javax.inject.Inject

class ListarTodosUseCase @Inject constructor(
    private val repository: PacienteRepository
){

    suspend operator fun invoke(): TodosResponse {
        return repository.listarTodos()
    }
}