package com.idat.apppt73013468.auth.data.repository

import android.util.Log
import com.idat.apppt73013468.core.bd.PacienteDao
import com.idat.apppt73013468.core.bd.PacienteEntity
import com.idat.apppt73013468.core.model.PacienteModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepository @Inject constructor(
    private val pacienteDao: PacienteDao
) {

    val listaPacientes: Flow<List<PacienteModel>> =
        pacienteDao.getAllPaciente().map { items -> items.map { PacienteModel(it.id, it.codpaciente, it.password, it.nombreapellido, it.celular) } }

    suspend fun insertarPaciente(pacienteEntity: PacienteEntity) {
        pacienteDao.insertarPaciente(pacienteEntity)
        Log.i("test-insertarPaciente", "Paciente insertado: $pacienteEntity")
    }

    suspend fun addPaciente(pacienteModel: PacienteModel) {
        pacienteDao.addPaciente(pacienteModel.toData())
    }

}

fun PacienteModel.toData(): PacienteEntity{
    return PacienteEntity(this.id, this.codpaciente, this.password, this.nombreapellido, this.celular)
}