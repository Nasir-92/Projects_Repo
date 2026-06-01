package com.pmdm.ecobite.data.room.mensaje

import com.pmdm.ecobite.data.room.toMensaje
import com.pmdm.ecobite.data.room.toMensajeEntity

import com.pmdm.ecobite.models.Mensaje
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class MensajeRepository (
    private val mensajesDao: MensajeDao
) {
    suspend fun delete(id:Int) = withContext(Dispatchers.IO) {
        mensajesDao.delete(id)
    }
    suspend fun getAll(): List<Mensaje> = withContext(Dispatchers.IO) {
        mensajesDao.getAll().map { it.toMensaje() }

    }
    suspend fun insert(mensaje: Mensaje) = withContext(Dispatchers.IO) {
        mensajesDao.insert(mensaje.toMensajeEntity())
    }
    suspend fun getById(id:Int) = withContext(Dispatchers.IO){
        mensajesDao.getById(id)
    }

}