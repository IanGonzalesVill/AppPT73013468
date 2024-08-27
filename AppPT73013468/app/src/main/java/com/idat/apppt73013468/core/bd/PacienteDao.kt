package com.idat.apppt73013468.core.bd

//import androidx.lifecycle.LiveData
//import androidx.room.Query
//import androidx.room.Update
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PacienteDao {

//        @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insertarpaciente(vararg pacienteEntity: PacienteEntity)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertarPaciente(pacienteEntity: PacienteEntity)

    @Insert
    suspend fun addPaciente(item: PacienteEntity)

//    @Insert
//    suspend fun addPacient(pacienteEntity: PacienteEntity)

    @Query("SELECT * FROM paciente")
    fun getAllPaciente(): Flow<List<PacienteEntity>>

//    @Query("SELECT * FROM paciente")
//    fun listarPacientes(): List<PacienteEntity>
//
//    @Update
//    suspend fun actualizarpaciente(vararg personaEntity: PacienteEntity)
//
//    @Query("DELETE FROM persona")
//    suspend fun eliminarPaciente()
//
//    @Query("SELECT * FROM persona LIMIT 1")
//    fun obtenerPaciente(): LiveData<PacienteEntity>

}