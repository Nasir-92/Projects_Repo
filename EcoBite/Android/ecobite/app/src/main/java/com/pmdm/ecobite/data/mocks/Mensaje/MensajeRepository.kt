package com.pmdm.ecobite.data.mocks.mensaje

import com.pmdm.ecobite.models.Mensaje

class MensajeRepository(
    private val dao: MensajeDaoMock = MensajeDaoMock()
) {

    fun getAll(): List<Mensaje> =
        dao.getAll().toMensajes()

    fun getById(id: Int): Mensaje? =
        dao.getById(id)?.toMensaje()

    fun insert(mensaje: Mensaje) {
        dao.insert(mensaje.toMensajeMock())
    }

    fun delete(id: Int) {
        dao.delete(id)
    }
}