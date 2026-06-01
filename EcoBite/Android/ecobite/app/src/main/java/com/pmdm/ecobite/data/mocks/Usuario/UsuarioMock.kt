package com.pmdm.ecobite.data.mocks.usuario

import java.time.LocalDateTime

data class UsuarioMock(
    val idUsuario: Int,
    val nombre: String,
    val apellidos: String,
    val telefono: String,
    val email: String,
    val password: String?,
    val ubicacion: String,
    val rol: String,
    val createdAt: String?
)