package com.pmdm.ecobite.network

import com.pmdm.ecobite.data.remote.dto.LoginDto
import com.pmdm.ecobite.data.remote.dto.UsuarioCreateDto
import com.pmdm.ecobite.models.*
import retrofit2.Response
import retrofit2.http.*

interface EcoBiteApiService {

    @GET("usuarios")
    suspend fun getUsuarios():
            Response<List<Usuario>>

    @GET("usuarios/{id}")
    suspend fun getUsuarioById(
        @Path("id") id: Int
    ): Response<Usuario>

    @POST("usuarios")
    suspend fun crearUsuario(
        @Body usuario: UsuarioCreateDto
    ): Response<Usuario>

    @PUT("usuarios/{id}/password")
    suspend fun cambiarPasswordUsuario(
        @Path("id") id: Int,
        @Body usuario: UsuarioCreateDto
    ): Response<Map<String, String>>

    @GET("recetas")
    suspend fun getRecetas():
            Response<List<Receta>>

    @GET("recetas/{id}")
    suspend fun getRecetaById(
        @Path("id") id: Int
    ): Response<Receta>

    @POST("recetas")
    suspend fun crearReceta(
        @Body receta: RecetaCreateDTO
    ): Response<Int>

    @DELETE("recetas/{id}")
    suspend fun borrarReceta(
        @Path("id") id: Int
    ): Response<Map<String, String>>


    @GET("restaurantes")
    suspend fun getRestaurantes():
            Response<List<Restaurante>>

    @GET("restaurantes/{id}")
    suspend fun getRestauranteById(
        @Path("id") id: Int
    ): Response<Restaurante>

    @POST("restaurantes")
    suspend fun crearRestaurante(
        @Body restaurante: RestauranteCreateDTO
    ): Response<Restaurante>

    @GET("restaurantes/{id}/recetas")
    suspend fun getRecetasByRestaurante(
        @Path("id") id: Int
    ): Response<List<Receta>>

    @PUT("restaurantes/{id}/password")
    suspend fun cambiarPasswordRestaurante(
        @Path("id") id: Int,
        @Body restaurante: RestauranteCreateDTO
    ): Response<Map<String, String>>

    @PUT("restaurantes/{id}/configuration")
    suspend fun actualizarConfiguracionRestaurante(
        @Path("id") id: Int,
        @Body restaurante: RestauranteCreateDTO
    ): Response<Map<String, String>>

    @POST("usuarios/login")
    suspend fun login(
        @Body usuario: LoginDto
    ): Response<UsuarioCreateDto>


}