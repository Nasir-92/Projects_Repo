package com.pmdm.ecobite.data.mocks.receta

import java.time.LocalDateTime

class RecetaDaoMock {

    private val recetas = mutableListOf(

        RecetaMock(
            18,
            5,
            "Eco Burger",
            "Hamburguesa vegetal con ingredientes ecológicos",
            "1. Preparar pan\n2. Añadir hamburguesa\n3. Añadir verduras",
            "ecoburger.jpg",
            LocalDateTime.now()
        ),

        RecetaMock(
            19,
            5,
            "Eco Wrap",
            "Wrap saludable con vegetales frescos",
            "1. Preparar tortilla\n2. Añadir relleno\n3. Enrollar",
            "ecowrap.jpg",
            LocalDateTime.now()
        ),

        RecetaMock(
            20,
            7,
            "Green Pasta",
            "Pasta integral con salsa verde",
            "1. Cocer pasta\n2. Preparar salsa\n3. Mezclar",
            "greenpasta.jpg",
            LocalDateTime.now()
        ),

        RecetaMock(
            13,
            4,
            "Plato de kebab",
            "Plato mixto dos salsas todo, un poco picante",
            "Pedir a trabajador amigo",
            "kebabplato.jpg",
            LocalDateTime.now()
        )
    )

    fun getAll(): List<RecetaMock> = recetas

    fun getById(id: Int): RecetaMock? =
        recetas.find { it.idReceta == id }

    fun getByRestaurante(idRestaurante: Int): List<RecetaMock> =
        recetas.filter { it.idRestaurante == idRestaurante }

    fun insert(receta: RecetaMock) {
        recetas.add(receta)
    }

    fun update(receta: RecetaMock) {
        val index = recetas.indexOfFirst { it.idReceta == receta.idReceta }
        if (index != -1) {
            recetas[index] = receta
        }
    }

    fun delete(id: Int) {
        recetas.removeIf { it.idReceta == id }
    }
}