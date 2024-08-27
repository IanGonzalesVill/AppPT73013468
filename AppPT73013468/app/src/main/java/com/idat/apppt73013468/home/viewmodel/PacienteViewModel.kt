package com.idat.apppt73013468.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idat.apppt73013468.core.bd.PacienteDao
import com.idat.apppt73013468.core.bd.PacienteEntity
import com.idat.apppt73013468.home.data.network.response.PhotosResponse
import com.idat.apppt73013468.home.data.network.response.TodosResponse
import com.idat.apppt73013468.home.domain.ListarPhotosUseCase
import com.idat.apppt73013468.home.domain.ListarTodosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PacienteViewModel @Inject constructor(
    private val listarTodosUseCase: ListarTodosUseCase,
    private val listarPhotosUseCase: ListarPhotosUseCase,
//    private val listarPacientesUseCase: ListarPacientesUseCase,
//    private val pacienteDao: PacienteDao
//    private val obtenerPersonaUseCase: ObtenerPersonaUseCase,
//    private val eliminarPersonaUseCase: EliminarPersonaUseCase
) : ViewModel() {
    //Todos
    private val _todosResponse = MutableLiveData<TodosResponse>()
    val todosResponse: LiveData<TodosResponse> = _todosResponse
    //Photos
    private val _photosResponse = MutableLiveData<PhotosResponse>()
    val photosResponse: LiveData<PhotosResponse> = _photosResponse

//    //Pacientes
//    private val _listarpacientes = MutableLiveData<PacienteEntity>()
//    val listarpacientes: LiveData<PacienteEntity> = _listarpacientes

//    val persona: LiveData<PacienteEntity> = listarTodosUseCase()

    init {
        listarTodos()
        listarPhotos()
//        listarPacientes()
    }

    fun listarTodos(){
        viewModelScope.launch {
            val response  = listarTodosUseCase()
            _todosResponse.value = response
        }
    }

    fun listarPhotos(){
        viewModelScope.launch {
            val response  = listarPhotosUseCase()
            _photosResponse.value = response
        }
    }
//    fun listarPacientes() {
//        viewModelScope.launch(Dispatchers.IO) {
//            val pacientes = pacienteDao.listarPacientes()
//        }
//    }

//    fun eliminarPersona(){
//        viewModelScope.launch {
//            eliminarPersonaUseCase()
//        }
//    }
}