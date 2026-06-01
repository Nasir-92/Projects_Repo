package com.pmdm.ecobite.models

import java.io.Serializable

data class RestauranteCreateDTO(

    val nombre: String,

    val email: String,

    val password: String,

    val telefono: String?,

    val ubicacion: String?,

    val horario: String?,

    val descripcion: String?,

    val imagen: String?

) : Serializable