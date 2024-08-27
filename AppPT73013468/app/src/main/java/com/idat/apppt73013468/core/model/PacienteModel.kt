package com.idat.apppt73013468.core.model

data class PacienteModel (
    val id: Int = System.currentTimeMillis().hashCode(),
    val codpaciente: String,
    val password: String,
    val nombreapellido: String,
    val celular: String
)
