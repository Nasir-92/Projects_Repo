package com.pmdm.ecobite.data.room.usuario

import com.pmdm.ecobite.data.room.toRestaurante
import com.pmdm.ecobite.data.room.toRestauranteEntity
import com.pmdm.ecobite.data.room.toUsuario
import com.pmdm.ecobite.data.room.toUsuarioEntity
import com.pmdm.ecobite.models.Restaurante
import com.pmdm.ecobite.models.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UsuarioRepository (private val usuarioDao: UsuarioDao){
    suspend fun insert (usuario: Usuario)= withContext(Dispatchers.IO) {
        usuarioDao.insert(usuario.toUsuarioEntity())
    }
    suspend fun getAll(): List<Usuario> = withContext(Dispatchers.IO) {
        usuarioDao.getAll().map { it.toUsuario() }
    }
    suspend fun getById(id:Int) = withContext(Dispatchers.IO) {
        usuarioDao.getById(id)
    }
    suspend fun update(usuario: Usuario)= withContext(Dispatchers.IO) {
        usuarioDao.update(usuario.toUsuarioEntity())
    }
    suspend fun count()= withContext(Dispatchers.IO) {
        usuarioDao.count()
    }
    suspend fun getByEmail(email:String)= withContext(Dispatchers.IO) {
        usuarioDao.getByEmail(email)
    }

}