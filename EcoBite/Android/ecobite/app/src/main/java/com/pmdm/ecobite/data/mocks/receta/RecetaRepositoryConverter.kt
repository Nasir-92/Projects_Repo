package com.pmdm.ecobite.data.mocks.receta

import com.pmdm.ecobite.models.Receta

fun RecetaMock.toReceta() = Receta(
    idReceta = idReceta,
    idRestaurante = idRestaurante,
    nombre = nombre,
    descripcion = descripcion,
    pasos = pasos,
    imagen = imagen,
    createdAt = createdAt
)

fun Receta.toRecetaMock() = RecetaMock(
    idReceta = idReceta,
    idRestaurante = idRestaurante,
    nombre = nombre,
    descripcion = descripcion,
    pasos = pasos,
    imagen = imagen,
    createdAt = createdAt
)

fun List<RecetaMock>.toRecetas() = this.map { it.toReceta() }

fun List<Receta>.toRecetasMock() = this.map { it.toRecetaMock() }