package com.pmdm.ecobite.data.room.restaurante

import com.pmdm.ecobite.data.room.toReceta
import com.pmdm.ecobite.data.room.toRestaurante
import com.pmdm.ecobite.data.room.toRestauranteEntity
import com.pmdm.ecobite.models.Receta
import com.pmdm.ecobite.models.Restaurante
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RestauranteRepository(private val restauranteDao: RestauranteDao) {
    suspend fun insert(restaurante: Restaurante)= withContext(Dispatchers.IO) {
        restauranteDao.insert(restaurante.toRestauranteEntity())
    }

    suspend fun getAll(): List<Restaurante> = withContext(Dispatchers.IO) {
        restauranteDao.getAll().map { it.toRestaurante() }
    }
    suspend fun getById(id:Int) = withContext(Dispatchers.IO) {
        restauranteDao.getById(id)
    }
    suspend fun update(restaurante: Restaurante)= withContext(Dispatchers.IO) {
        restauranteDao.update(restaurante.toRestauranteEntity())
    }

    suspend fun count()= withContext(Dispatchers.IO) {
        restauranteDao.count()
    }
}