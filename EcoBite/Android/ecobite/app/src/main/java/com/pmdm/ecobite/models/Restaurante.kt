package com.pmdm.ecobite.models

import java.time.LocalDateTime

data class Restaurante(
    val idRestaurante: Int,
    val nombre: String,
    val email: String,
    val password: String,
    val telefono: String,
    val ubicacion: String,
    val horario: String,
    val descripcion: String,
    val imagen: String,
    val createdAt: LocalDateTime
)