package com.idat.apppt73013468.auth.domain

import com.idat.apppt73013468.auth.data.repository.LoginRepository
import com.idat.apppt73013468.core.model.PacienteModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPacientesUseCase @Inject constructor(private val loginRepository: LoginRepository) {

    operator fun invoke(): Flow<List<PacienteModel>> = loginRepository.listaPacientes

}