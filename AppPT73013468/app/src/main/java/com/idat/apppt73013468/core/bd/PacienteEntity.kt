package com.idat.apppt73013468.core.bd

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "paciente")
data class PacienteEntity(
    @PrimaryKey//(autoGenerate = true)
    val id: Int,
    val codpaciente: String,
    val password: String,
    val nombreapellido: String,
    val celular: String
)
