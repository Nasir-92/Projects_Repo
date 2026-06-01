package com.pmdm.ecobite.data.mocks.restaurante

import java.time.LocalDateTime

data class RestauranteMock(
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