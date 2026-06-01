package com.pmdm.ecobite.data.mocks.restaurante

import com.pmdm.ecobite.models.Restaurante

class RestauranteRepository(
    private val dao: RestauranteDaoMock = RestauranteDaoMock()
) {

    fun getAll(): List<Restaurante> =
        dao.getAll().toRestaurantes()

    fun getById(id: Int): Restaurante? =
        dao.getById(id)?.toRestaurante()

    fun insert(restaurante: Restaurante) {
        dao.insert(restaurante.toRestauranteMock())
    }

    fun update(restaurante: Restaurante) {
        dao.update(restaurante.toRestauranteMock())
    }

    fun delete(id: Int) {
        dao.delete(id)
    }
}