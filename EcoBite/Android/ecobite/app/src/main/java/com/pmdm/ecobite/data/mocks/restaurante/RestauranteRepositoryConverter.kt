package com.pmdm.ecobite.data.mocks.restaurante

import com.pmdm.ecobite.models.Restaurante

fun RestauranteMock.toRestaurante() = Restaurante(
    idRestaurante = idRestaurante,
    nombre = nombre,
    email = email,
    password = password,
    telefono = telefono,
    ubicacion = ubicacion,
    horario = horario,
    descripcion = descripcion,
    imagen = imagen,
    createdAt = createdAt
)

fun Restaurante.toRestauranteMock() = RestauranteMock(
    idRestaurante = idRestaurante,
    nombre = nombre,
    email = email,
    password = password,
    telefono = telefono,
    ubicacion = ubicacion,
    horario = horario,
    descripcion = descripcion,
    imagen = imagen,
    createdAt = createdAt
)

fun List<RestauranteMock>.toRestaurantes() =
    this.map { it.toRestaurante() }

fun List<Restaurante>.toRestaurantesMock() =
    this.map { it.toRestauranteMock() }