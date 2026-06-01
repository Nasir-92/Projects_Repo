package com.pmdm.ecobite.data.mocks.mensaje

import MensajeMock
import com.pmdm.ecobite.models.Mensaje

fun MensajeMock.toMensaje() = Mensaje(
    idMensaje = idMensaje,
    idRemitente = idRemitente,
    contenido = contenido,
    fechaEnvio = fechaEnvio
)

fun Mensaje.toMensajeMock() = MensajeMock(
    idMensaje = idMensaje,
    idRemitente = idRemitente,
    contenido = contenido,
    fechaEnvio = fechaEnvio
)

fun List<MensajeMock>.toMensajes() =
    this.map { it.toMensaje() }

fun List<Mensaje>.toMensajesMock() =
    this.map { it.toMensajeMock() }