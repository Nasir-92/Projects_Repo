package com.pmdm.ecobite.data.mocks.receta

import com.pmdm.ecobite.models.Receta

class RecetaRepository(
    private val dao: RecetaDaoMock = RecetaDaoMock()
) {

    fun getAll(): List<Receta> =
        dao.getAll().toRecetas()

    fun getById(id: Int): Receta? =
        dao.getById(id)?.toReceta()

    fun getByRestaurante(idRestaurante: Int): List<Receta> =
        dao.getByRestaurante(idRestaurante).toRecetas()

    fun insert(receta: Receta) {
        dao.insert(receta.toRecetaMock())
    }

    fun update(receta: Receta) {
        dao.update(receta.toRecetaMock())
    }

    fun delete(id: Int) {
        dao.delete(id)
    }
}