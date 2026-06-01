package com.pmdm.ecobite.data.room

import com.pmdm.ecobite.data.room.mensaje.MensajeEntity
import com.pmdm.ecobite.data.room.receta.RecetaEntity
import com.pmdm.ecobite.data.room.restaurante.RestauranteEntity
import com.pmdm.ecobite.data.room.usuario.UsuarioEntity
import com.pmdm.ecobite.models.Mensaje
import com.pmdm.ecobite.models.Receta
import com.pmdm.ecobite.models.Restaurante
import com.pmdm.ecobite.models.Usuario

fun Mensaje.toMensajeEntity() = MensajeEntity(
    idMensaje = this.idMensaje,
    idRemitente = this.idRemitente,
    contenido = this.contenido,
    fechaEnvio = this.fechaEnvio
)
fun MensajeEntity.toMensaje() = Mensaje(
    idMensaje = this.idMensaje,
    idRemitente = this.idRemitente,
    contenido = this.contenido,
    fechaEnvio = this.fechaEnvio
)

fun Receta.toRecetaEntity() = RecetaEntity(
    idReceta = this.idReceta,
    idRestaurante = this.idRestaurante,
    nombre = this.nombre,
    descripcion = this.descripcion,
    pasos = this.pasos,
    imagen = this.imagen,
    createdAt = this.createdAt
)
fun RecetaEntity.toReceta() = Receta(
    idReceta = this.idReceta,
    idRestaurante = this.idRestaurante,
    nombre = this.nombre,
    descripcion = this.descripcion,
    pasos = this.pasos,
    imagen = this.imagen,
    createdAt = this.createdAt
)

fun Restaurante.toRestauranteEntity() = RestauranteEntity(
    idRestaurante = this.idRestaurante,
    nombre = this.nombre,
    email = this.email,
    password = this.password,
    telefono = this.telefono,
    ubicacion = this.ubicacion,
    horario = this.horario,
    descripcion = this.descripcion,
    imagen = this.imagen,
    createdAt = this.createdAt
)
fun RestauranteEntity.toRestaurante() = Restaurante(
    idRestaurante = this.idRestaurante,
    nombre = this.nombre,
    email = this.email,
    password = this.password,
    telefono = this.telefono,
    ubicacion = this.ubicacion,
    horario = this.horario,
    descripcion = this.descripcion,
    imagen = this.imagen,
    createdAt = this.createdAt
)

fun Usuario.toUsuarioEntity() = UsuarioEntity(
    idUsuario = this.idUsuario,
    nombre = this.nombre,
    apellidos = this.apellidos,
    telefono = this.telefono,
    email = this.email,
    password = this.password,
    ubicacion = this.ubicacion,
    rol = this.rol,
    createdAt = this.createdAt
)

fun UsuarioEntity.toUsuario() = Usuario(
    idUsuario = this.idUsuario,
    nombre = this.nombre,
    apellidos = this.apellidos,
    telefono = this.telefono,
    email = this.email,
    password = this.password,
    ubicacion = this.ubicacion,
    rol = this.rol,
    createdAt = this.createdAt
)