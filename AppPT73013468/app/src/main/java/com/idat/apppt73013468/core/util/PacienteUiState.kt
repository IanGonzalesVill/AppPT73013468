package com.idat.apppt73013468.core.util

import com.idat.apppt73013468.core.model.PacienteModel

sealed class PacienteUiState {
    object Loading:PacienteUiState()
    data class Error(val throwable: Throwable):PacienteUiState()
    data class Success(val tasks:List<PacienteModel>):PacienteUiState()
}