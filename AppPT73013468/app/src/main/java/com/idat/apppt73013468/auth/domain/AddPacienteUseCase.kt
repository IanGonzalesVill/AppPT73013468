package com.idat.apppt73013468.auth.domain

import com.idat.apppt73013468.auth.data.repository.LoginRepository
import com.idat.apppt73013468.core.model.PacienteModel
import javax.inject.Inject

class AddPacienteUseCase @Inject constructor(private val loginRepository: LoginRepository) {
    suspend operator fun invoke(pacienteModel: PacienteModel){
        loginRepository.addPaciente(pacienteModel)
    }

}