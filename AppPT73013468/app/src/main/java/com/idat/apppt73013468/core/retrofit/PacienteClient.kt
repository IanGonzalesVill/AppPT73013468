package com.idat.apppt73013468.core.retrofit

import com.idat.apppt73013468.home.data.network.response.PhotosResponse
import com.idat.apppt73013468.home.data.network.response.TodosResponse
import retrofit2.Response
import retrofit2.http.GET


interface PacienteClient {

//    @POST("login.php")
//    suspend fun login(@Body loginRequest: LoginRequest):
//            Response<LoginResponse>
//
//    @PUT("persona.php")
//    suspend fun registro(@Body request: RegistroRequest):
//            Response<RegistroResponse>

    @GET("todos")
    suspend fun listarTodos(): Response<TodosResponse>

    @GET("photos")
    suspend fun listarPhotos(): Response<PhotosResponse>

//    @POST("personavoluntaria.php")
//    suspend fun registrarVoluntario(@Body request: VoluntarioRequest):
//            Response<VoluntarioResponse>

}