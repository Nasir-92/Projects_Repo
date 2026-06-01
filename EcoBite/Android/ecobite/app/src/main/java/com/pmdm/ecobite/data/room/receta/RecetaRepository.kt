package com.pmdm.ecobite.data.room.receta

import com.pmdm.ecobite.data.room.toReceta
import com.pmdm.ecobite.data.room.toRecetaEntity
import com.pmdm.ecobite.models.Receta
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecetaRepository(private val recetasDao: RecetaDao) {
    suspend fun insert(receta: Receta) = withContext(Dispatchers.IO) {
        recetasDao.insert(receta.toRecetaEntity())
    }
    suspend fun delete(id:Int) = withContext(Dispatchers.IO) {
        recetasDao.delete(id)
    }
    suspend fun getAll(): List<Receta> = withContext(Dispatchers.IO) {
        recetasDao.getAll().map { it.toReceta() }
    }
    suspend fun getById(id:Int) = withContext(Dispatchers.IO){
        recetasDao.getById(id)
    }
    suspend fun update(receta: Receta)  = withContext(Dispatchers.IO){
        recetasDao.update(receta.toRecetaEntity())
    }
    suspend fun getByRestaurante(id: Int) = withContext(Dispatchers.IO){
        recetasDao.getByRestaurante(id)
    }


}