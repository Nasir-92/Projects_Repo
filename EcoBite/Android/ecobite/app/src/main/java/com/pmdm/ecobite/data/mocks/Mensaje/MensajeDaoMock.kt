package com.pmdm.ecobite.data.mocks.mensaje

import MensajeMock
import java.time.LocalDateTime

class MensajeDaoMock {

    private val mensajes = mutableListOf(

        MensajeMock(
            1,
            1,
            "Hola, ¿tenéis menú vegetariano?",
            LocalDateTime.now()
        ),

        MensajeMock(
            2,
            2,
            "Sí, tenemos varias opciones.",
            LocalDateTime.now()
        )
    )

    fun getAll(): List<MensajeMock> = mensajes

    fun getById(id: Int): MensajeMock? =
        mensajes.find { it.idMensaje == id }

    fun insert(mensaje: MensajeMock) {
        mensajes.add(mensaje)
    }

    fun delete(id: Int) {
        mensajes.removeIf { it.idMensaje == id }
    }
}