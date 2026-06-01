package com.pmdm.ecobite.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Usuario(
    val idUsuario: Int,
    val nombre: String,
    val apellidos: String,
    val telefono: String,
    val email: String,
    val password: String? = null,
    val ubicacion: String,
    val rol: String,
    @SerializedName("created_at")
    val createdAt: String?
): Serializable