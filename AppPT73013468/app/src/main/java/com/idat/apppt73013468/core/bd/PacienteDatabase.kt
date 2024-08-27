package com.idat.apppt73013468.core.bd

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PacienteEntity::class], version = 1)
abstract class PacienteDatabase : RoomDatabase() {
    companion object {
        const val DATABASE_NAME = "pacientedb"
    }

    abstract fun getPacienteDao(): PacienteDao

}