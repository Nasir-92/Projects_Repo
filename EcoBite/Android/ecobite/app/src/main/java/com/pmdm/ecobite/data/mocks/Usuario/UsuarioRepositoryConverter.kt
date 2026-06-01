package com.pmdm.ecobite.data.mocks.usuario

import com.pmdm.ecobite.models.Usuario


fun UsuarioMock.toUsuario() = Usuario(
    idUsuario = idUsuario,
    nombre = nombre,
    apellidos = apellidos,
    telefono = telefono,
    email = email,
    password = password,
    ubicacion = ubicacion,
    rol = rol,
    createdAt = createdAt
)

fun Usuario.toUsuarioMock() = UsuarioMock(
    idUsuario = idUsuario,
    nombre = nombre,
    apellidos = apellidos,
    telefono = telefono,
    email = email,
    password = password,
    ubicacion = ubicacion,
    rol = rol,
    createdAt = createdAt
)

fun List<UsuarioMock>.toUsuarios() =
    this.map { it.toUsuario() }

fun List<Usuario>.toUsuariosMock() =
    this.map { it.toUsuarioMock() }