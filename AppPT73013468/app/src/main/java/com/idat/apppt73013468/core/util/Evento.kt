//package com.idat.apppt73013468.core.util
//
//open class Evento<out T>(private val contenido: T) {
//
//    var hasBeenHandled = false
//        private set
//
//    fun obtenerContenidoSiCambio(): T?{
//        return if (hasBeenHandled){
//            null
//        }else{
//            hasBeenHandled = true
//            contenido
//        }
//    }
//
//    fun obtenerContenido(): T = contenido
//
//}