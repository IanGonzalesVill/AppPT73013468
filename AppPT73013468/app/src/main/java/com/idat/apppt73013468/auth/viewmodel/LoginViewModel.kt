package com.idat.apppt73013468.auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idat.apppt73013468.auth.data.repository.LoginRepository
import com.idat.apppt73013468.auth.domain.AddPacienteUseCase
import com.idat.apppt73013468.auth.domain.GetPacientesUseCase
import com.idat.apppt73013468.core.bd.PacienteEntity
import com.idat.apppt73013468.core.model.PacienteModel
import com.idat.apppt73013468.core.util.PacienteUiState
import com.idat.apppt73013468.core.util.PacienteUiState.Error
import com.idat.apppt73013468.core.util.PacienteUiState.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
    getPacientesUseCase: GetPacientesUseCase,
    private val addPacienteUseCase: AddPacienteUseCase
) : ViewModel() {

    val uiState: StateFlow<PacienteUiState> = getPacientesUseCase()
        .map(::Success)
        .catch { Error(it) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), PacienteUiState.Loading)

//    val pacienteDao = MiApp.pacienteDatabase.getPacienteDao()

//    val getAllPacients : LiveData<List<PacienteEntity>> = pacienteDao.getAllPaciente()

//    fun getAllPaciente(livedata: LiveData<List<PacienteEntity>>) {
//        viewModelScope.launch(Dispatchers.IO) { pacienteDao.getAllPaciente() }
//    }

    fun onPacienteCreated(pacienteModel: PacienteModel) {
        //_showDialog.value = false
        //Log.i("birza", task)
        //_tasks.add(TaskModel(task = task))
        viewModelScope.launch {
            addPacienteUseCase(
                PacienteModel(
                    codpaciente = pacienteModel.codpaciente,
                    password = pacienteModel.password,
                    nombreapellido = pacienteModel.nombreapellido,
                    celular = pacienteModel.celular
                )
            )
        }
    }


    init {

    }

//    fun addPacient(codpaciente:String, password:String, nombreapellido:String, celular:String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            pacienteDao.addPacient(PacienteEntity(codpaciente = codpaciente, password = password, nombreapellido = nombreapellido, celular =  celular))
//        }
//    }

    fun insertarPaciente(pacienteEntity: PacienteEntity) = viewModelScope.launch {
        loginRepository.insertarPaciente(pacienteEntity = pacienteEntity)
    }
}

