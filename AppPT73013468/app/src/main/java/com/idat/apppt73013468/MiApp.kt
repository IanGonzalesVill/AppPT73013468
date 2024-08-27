package com.idat.apppt73013468

import android.app.Application
import androidx.room.Room
import com.idat.apppt73013468.core.bd.PacienteDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MiApp : Application() {

//    companion object{
//        lateinit var pacienteDatabase: PacienteDatabase
//    }
//
//    override fun onCreate() {
//        super.onCreate()
//        pacienteDatabase = Room.databaseBuilder(
//            applicationContext,
//            PacienteDatabase::class.java,
//            PacienteDatabase.DATABASE_NAME
//        ).build()
//    }
}