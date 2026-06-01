package com.pmdm.ecobite.data.mocks.restaurante

import java.time.LocalDateTime

class RestauranteDaoMock {

    private val restaurantes = mutableListOf(

        RestauranteMock(
            5,
            "Eco Food",
            "ecoFood@ecobite.com",
            "1234",
            "6003334444",
            "Valencia",
            "11:00-23:00",
            "Vegano y sostenible",
            "ecofood.jpg",
            LocalDateTime.now()
        ),

        RestauranteMock(
            7,
            "Green Garden",
            "green@ecobite.com",
            "1234",
            "123456",
            "Alicante",
            "10:00-22:00",
            "Cocina saludable",
            "greengarden.jpg",
            LocalDateTime.now()
        ),

        RestauranteMock(
            4,
            "KebabBueno",
            "kebabBueno@hotmail.es",
            "1234",
            "1234567890",
            "Alicante",
            "9:00-23:00",
            "Rica comida turca y variada",
            "kebabbueno.jpg",
            LocalDateTime.now()
        )
    )

    fun getAll(): List<RestauranteMock> = restaurantes

    fun getById(id: Int): RestauranteMock? =
        restaurantes.find { it.idRestaurante == id }

    fun insert(restaurante: RestauranteMock) {
        restaurantes.add(restaurante)
    }

    fun update(restaurante: RestauranteMock) {
        val index = restaurantes.indexOfFirst { it.idRestaurante == restaurante.idRestaurante }
        if (index != -1) {
            restaurantes[index] = restaurante
        }
    }

    fun delete(id: Int) {
        restaurantes.removeIf { it.idRestaurante == id }
    }
}