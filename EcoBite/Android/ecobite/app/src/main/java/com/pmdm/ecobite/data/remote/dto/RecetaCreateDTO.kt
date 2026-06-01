package com.pmdm.ecobite.models

import java.io.Serializable

data class RecetaCreateDTO(

    val idRestaurante: Int,

    val nombre: String,

    val descripcion: String?,

    val pasos: String?,

    // BASE64
    val imagen: String?

) : Serializable