package com.pmdm.ecobite.data.mocks.restaurante

import com.pmdm.ecobite.models.Receta

data class Restaurante(
    val idRestaurante: Int,
    val nombre: String,
    val email: String,
    val telefono: String,
    val password: String,
    val ubicacion: String,
    val horario: String,
    val descripcion: String,
    val recetas: List<Receta> = emptyList()
)