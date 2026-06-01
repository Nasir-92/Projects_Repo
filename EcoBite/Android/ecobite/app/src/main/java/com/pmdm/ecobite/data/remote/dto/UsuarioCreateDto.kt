package com.pmdm.ecobite.data.remote.dto

import java.io.Serializable

data class UsuarioCreateDto(

    val nombre: String,

    val apellidos: String,

    val email: String,

    val nuevaPassword: String,

    val telefono: String?,

    val ubicacion: String?

) : Serializable