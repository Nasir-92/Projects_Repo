package com.pmdm.ecobite.ui.features.restaurante

import com.pmdm.ecobite.models.Receta
import com.pmdm.ecobite.models.Restaurante

data class RestauranteUiState(

    val searchText: String = "",

    val restaurante: Restaurante? = null,

    val recetas: List<Receta> = emptyList(),

    val recetasFiltradas: List<Receta> = emptyList(),

    val indiceRecetaSeleccionada: Int = 0
)